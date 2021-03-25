package com.hyuk.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyuk.baseball.domain.stadium.Stadium;
import com.hyuk.baseball.domain.stadium.StadiumRepository;
import com.hyuk.baseball.domain.team.Team;
import com.hyuk.baseball.domain.team.TeamRepository;
import com.hyuk.baseball.exception.MyException;
import com.hyuk.baseball.web.dto.stadium.StadiumSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {
	private final StadiumRepository stadiumRepository;
	private final TeamRepository teamRepository;
	
	@Transactional
	public void 야구장등록(StadiumSaveReqDto stadiumSaveReqDto) {
		Team teamEntity = teamRepository.findByName(stadiumSaveReqDto.getTeamName())
				.orElseThrow(() -> {throw new MyException("존재하지 않는 팀입니다.");});
		
		Stadium stadium = Stadium.builder()
				.name(stadiumSaveReqDto.getStadiumName())
				.team(teamEntity)
				.build();
		
		if (teamEntity.getStadium() == null) {
			teamEntity.setStadium(stadium);
		}
		
		stadiumRepository.save(stadium);
	}
	
	@Transactional(readOnly = true)
	public List<Stadium> 야구장조회() {
		return stadiumRepository.findAll();
	}
	
	@Transactional
	public void 야구장삭제(int id) {
		Team teamEntity = teamRepository.findByStadiumId(id);
		teamEntity.setStadium(null);
		
		stadiumRepository.deleteById(id);
	}
}

package com.hyuk.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyuk.baseball.domain.stadium.Stadium;
import com.hyuk.baseball.domain.stadium.StadiumRepository;
import com.hyuk.baseball.domain.team.Team;
import com.hyuk.baseball.domain.team.TeamRepository;
import com.hyuk.baseball.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	private final TeamRepository teamRepository;
	private final StadiumRepository stadiumRepository;
	
	@Transactional
	public void 팀등록(TeamSaveReqDto teamSaveReqDto) {
		Team team = Team.builder()
				.name(teamSaveReqDto.getTeamName())
				.build();
		
		teamRepository.save(team);
	}
	
	@Transactional(readOnly = true)
	public List<Team> 팀조회() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public void 팀삭제(int id) {
		Stadium stadiumEntity = stadiumRepository.findByTeamId(id);
		if (stadiumEntity != null) {
			stadiumEntity.setTeam(null);			
		}
		
		teamRepository.deleteById(id);
	}
}

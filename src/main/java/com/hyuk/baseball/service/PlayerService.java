package com.hyuk.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyuk.baseball.domain.player.Player;
import com.hyuk.baseball.domain.player.PlayerRepository;
import com.hyuk.baseball.domain.team.Team;
import com.hyuk.baseball.domain.team.TeamRepository;
import com.hyuk.baseball.exception.MyException;
import com.hyuk.baseball.web.dto.player.PlayerSaveReqDto;
import com.hyuk.baseball.web.dto.player.PositionPlayerRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	private final EntityManager em;

	
	@Transactional
	public void 선수등록(PlayerSaveReqDto playerSaveReqDto) {
		Team teamEntity = teamRepository.findByName(playerSaveReqDto.getTeamName())
				.orElseThrow(() -> {throw new MyException("존재하지 않는 팀입니다.");});
		
		Player player = Player.builder()
				.name(playerSaveReqDto.getPlayerName())
				.position(playerSaveReqDto.getPosition())
				.team(teamEntity)
				.build();
		
		playerRepository.save(player);
	}
	
	@Transactional(readOnly = true)
	public List<Player> 선수조회() {
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 선수삭제(int id) {
		playerRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<PositionPlayerRespDto> 포지션별선수() {
		StringBuffer sb = new StringBuffer();
		sb.append("select p.position as 'position', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 2 THEN p.name ELSE null END)) as 'lotte', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 3 THEN p.name ELSE null END)) as 'samsung', ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 4 THEN p.name ELSE null END)) as 'kt' ");
		sb.append("from player p GROUP BY p.position");
		System.out.println("sb : " + sb.toString());
		
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		Query query = em.createNativeQuery(sb.toString());
		List<PositionPlayerRespDto> dto = jpaResultMapper.list(query, PositionPlayerRespDto.class);
		System.out.println(dto);
		return dto;
	}
}

package com.hyuk.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuk.baseball.domain.team.Team;
import com.hyuk.baseball.service.TeamService;
import com.hyuk.baseball.web.dto.CommonRespDto;
import com.hyuk.baseball.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	private final TeamService teamService;

	@GetMapping({"/", "/team"})
	public String home() {
		return "team/register";
	}
	
	@PostMapping("/team")
	public String save(TeamSaveReqDto teamSaveReqDto) {
		teamService.팀등록(teamSaveReqDto);
		return "redirect:/team/info";
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		teamService.팀삭제(id);
		return new CommonRespDto<>(1, null);
	}
	
	@GetMapping("/team/info")
	public String info(Model model) {
		List<Team> teams = teamService.팀조회();
		model.addAttribute("teams", teams);
		return "team/setting";
	}
	
}

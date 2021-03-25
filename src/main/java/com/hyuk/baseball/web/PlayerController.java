package com.hyuk.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuk.baseball.domain.player.Player;
import com.hyuk.baseball.service.PlayerService;
import com.hyuk.baseball.web.dto.CommonRespDto;
import com.hyuk.baseball.web.dto.player.PlayerSaveReqDto;
import com.hyuk.baseball.web.dto.player.PositionPlayerRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	private final PlayerService playerService;
	
	@GetMapping("/player")
	public String home() {
		return "player/register";
	}
	
	@PostMapping("/player")
	public String save(PlayerSaveReqDto playerSaveReqDto) {
		playerService.선수등록(playerSaveReqDto);
		return "redirect:/player/info";
	}
	
	@GetMapping("/player/info")
	public String info(Model model) {
		List<Player> players = playerService.선수조회();
		model.addAttribute("players", players);
		return "player/setting";
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		playerService.선수삭제(id);
		return new CommonRespDto<>(1, null);
	}
	
	@GetMapping("/player/position")
	public String positionInfo(Model model) {
		List<PositionPlayerRespDto> players = playerService.포지션별선수();
		model.addAttribute("players", players);
		return "player/positionplayer";
	}
	
}

package com.hyuk.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyuk.baseball.domain.stadium.Stadium;
import com.hyuk.baseball.service.StadiumService;
import com.hyuk.baseball.web.dto.CommonRespDto;
import com.hyuk.baseball.web.dto.stadium.StadiumSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	private final StadiumService stadiumService;
	
	@GetMapping("/stadium")
	public String home() {
		return "stadium/register";
	}
	
	@PostMapping("/stadium")
	public String save(StadiumSaveReqDto stadiumSaveReqDto) {
		stadiumService.야구장등록(stadiumSaveReqDto);
		return "redirect:/stadium/info";
	}
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody CommonRespDto<?> delete(@PathVariable int id) {
		stadiumService.야구장삭제(id);
		return new CommonRespDto<>(1, null);
	}
	
	@GetMapping("/stadium/info")
	public String info(Model model) {
		List<Stadium> stadiums = stadiumService.야구장조회();
		model.addAttribute("stadiums", stadiums);
		return "stadium/setting";
	}
	
}

package com.hyuk.baseball.web.dto.player;

import lombok.Data;

@Data
public class PlayerSaveReqDto {
	private String teamName;
	private String position;
	private String playerName;	
}

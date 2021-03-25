package com.hyuk.baseball.web.dto.stadium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StadiumSaveReqDto {
	private String stadiumName;
	private String teamName;
}

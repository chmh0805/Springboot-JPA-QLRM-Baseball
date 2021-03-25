package com.hyuk.baseball.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvicer {

	@ExceptionHandler
	public String myExceptionHandler(MyException e) {
		return e.getMessage();
	}
}

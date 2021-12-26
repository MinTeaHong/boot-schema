package com.salgam.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.salgam.form.ApiResult;

@RestControllerAdvice("com.salgam.controller.rest")
public class TestControllerAdvicer {
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiResult<?> handleTest(Exception ex) {
		return ApiResult.failed(500, "fail");
	}
}

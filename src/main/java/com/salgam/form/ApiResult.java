package com.salgam.form;

public class ApiResult<T> {
	
	private int statusCode;
	private final T data;
	private final String errorMasseage;

	ApiResult(int statusCode, T data, String error) {
		this.data = data;
		this.errorMasseage = error;
	}

	public static <T> ApiResult<T> succeed(T data) {
		return new ApiResult<>(200,data, null);
	}

	public static ApiResult<?> failed(int statusCode, Throwable throwable) {
		return failed(statusCode, throwable.getMessage());
	}

	public static ApiResult<?> failed(int statusCode, String message) {
		return new ApiResult<>(statusCode, null, message);
	}

}
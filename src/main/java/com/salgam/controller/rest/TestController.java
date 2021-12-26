package com.salgam.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.salgam.form.ApiResult;
import static com.salgam.form.ApiResult.succeed;

@RestController
@RequestMapping("test")
public class TestController {
	
	@GetMapping("")
	@ResponseBody
	public ApiResult<Object> test() {
		return succeed(new Object());
	}
	
	
}

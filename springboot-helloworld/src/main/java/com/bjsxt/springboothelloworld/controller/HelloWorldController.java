package com.bjsxt.springboothelloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
//	@Value("${hello.msg}")
	private String msg;

	@RequestMapping("/hello")
	public String showMsg(){
//		String str = null;
//		str.length();
//		int i = 5/0;
		throw new ApplicationException("出错了");
//		return this.msg;
	}
}

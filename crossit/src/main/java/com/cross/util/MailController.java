package com.cross.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {
	@Autowired
	MailService mailService;

	@RequestMapping(value = "/mail/test")
	public @ResponseBody String a(){
		mailService.sendMail("modernhart@daum.net", "cola8392@gmail.com", "aaa", "ssss");
		return "successfully send mail!";
	}
}

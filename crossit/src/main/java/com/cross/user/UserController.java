package com.cross.user;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cross.util.Validation;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/") //Îß§Ïπ≠ URL
	public String home(Locale locale, Model model) {
		logger.info("welcome ! admin page");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "/index"; //jsp ?åå?ùº
	}
	
	// findid
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public String findidPage(Model model){
		return "/main/findid";
	}
	
	@RequestMapping(value = "/testid" , method= RequestMethod.POST)
	@ResponseBody
	public HashMap findUserId(@RequestParam String user_name, @RequestParam String user_email) throws Exception{
		int result = 0;
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_email(user_email);
		String findid = userDao.findId(user);
		if(findid != null){
			result = 1;
		}
		HashMap map = new HashMap();
		map.put("resultCode",result);
		map.put("id", findid);
		System.out.println(map);
		return map;
	}
	
	//findpwd(temp password)
	@RequestMapping(value = "/test2", method=RequestMethod.GET)
	public String findpwPage(Model model){
		return "/main/findpw";
	}
	
	@RequestMapping(value = "/testpw" , method= RequestMethod.POST)
	@ResponseBody
	public HashMap findUserPw(@RequestParam String user_name, @RequestParam String user_email, @RequestParam String user_id) throws Exception{
		int result = 0;
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_email(user_email);
		user.setUser_id(user_id);
		String findpw = userDao.findPwd(user);
		String tempPwd = "";
		if(findpw != null){
			result = 1; //success
			tempPwd = Validation.getTempPwd(8);
			userDao.updateTempPwd(tempPwd);
		}
		HashMap map = new HashMap();
		map.put("resultCode",result);
		map.put("pw", tempPwd);
		System.out.println(map);
		return map;
	}
}

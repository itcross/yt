package com.cross.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cross.model.User;
import com.cross.service.UserDaoImpl;
import com.cross.util.MailService;
import com.cross.util.Validation;

@Controller
public class LoginController {
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Autowired
	MailService mailService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView loginPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String uid = (String)session.getAttribute("id");
		if(uid != null){
			mv.setViewName("redirect:/logins");
			return mv;
		}
		mv.setViewName("/main/login");
		return mv;
	}
	
	@RequestMapping(value = "/login.do" , method = RequestMethod.POST)
	@ResponseBody
	public int loginCheck(@RequestParam String user_id, @RequestParam String user_pwd, HttpSession session) throws Exception{
		int result = 0;
		User user = userDao.getUser(user_id);
		if(user != null){
			if(Validation.loginChk(user, user_pwd)){
				session.setAttribute("id", user_id);
				result = 1; //login success
			}
		}
		return result;	
	}
	
	@RequestMapping(value = "/logins", method = RequestMethod.GET)
	@ResponseBody
	public String loginSuccess(){
		return "<script>document.write(document.cookie);</script>";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	@ResponseBody
	public String logoutPage(HttpSession session){
		session.invalidate();
		return "·Î±×¾Æ¿ô ¼º°ø";
	}
	//cookie test
	@RequestMapping(value = "/cookie/make")
	public @ResponseBody String make(HttpServletResponse response){
		response.addCookie(new Cookie("name", "val"));
		return "ÄíÅ°»ý¼º";
	}
	@RequestMapping(value = "/cookie/view")
	public @ResponseBody String view(@CookieValue(value = "name", defaultValue = "0") String ck){
		System.out.println(ck);
		return "ÄíÅ° º¸¿©ÁÜ"+ck;
	}

}

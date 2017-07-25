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
import com.cross.service.RegiMybatisDAO;
import com.cross.service.UserDaoImpl;
import com.cross.util.MailService;
import com.cross.util.Validation;

@Controller
public class LoginController {
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	RegiMybatisDAO rDao;
	
	private 	static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
//	@RequestMapping(value = "/login",method = RequestMethod.GET)
//	public ModelAndView loginPage(HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		String uid = (String)session.getAttribute("id");
//		if(uid != null){
//			mv.setViewName("redirect:/logins");
//			return mv;
//		}
//		mv.setViewName("/main/login");
//		return mv;
//	}
//	
//	@RequestMapping(value = "/login.do" , method = RequestMethod.POST)
//	@ResponseBody
//	public int loginCheck(@RequestParam String user_id, @RequestParam String user_pwd, HttpSession session) throws Exception{
//		int result = 0;
//		User user = userDao.getUser(user_id);
//		if(user != null){
//			if(Validation.loginChk(user, user_pwd)){
//				session.setAttribute("id", user_id);
//				result = 1; //login success
//			}
//		}
//		return result;	
//	}
//	
//	@RequestMapping(value = "/logins", method = RequestMethod.GET)
//	@ResponseBody
//	public String loginSuccess(){
//		return "<script>document.write(document.cookie);</script>";
//	}
	
	@RequestMapping(value = "/loginform")
	public String loginForm(Model model) {
		//페이지 이동.
		
			return "login";
		
	}
	@RequestMapping(value = "/login" , method=RequestMethod.POST)
	public String login(@RequestParam String loginid,@RequestParam String loginpw,Model model,HttpSession session) {
	
		//세션 생성.

		boolean check=rDao.loginCheck(loginid, loginpw);
		if(check==true){
			//성공 화면 리턴
			session.setAttribute("id",loginid);
		    return "checkSuccess";
		}
		else{
			model.addAttribute("msg", "failure"); 
			return "login";
			//실패화면 리턴
		}
			
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	@ResponseBody
	public String logoutPage(HttpSession session){
		session.invalidate();
		return "로그아웃 성공";
	}
	//cookie test
	@RequestMapping(value = "/cookie/make")
	public @ResponseBody String make(HttpServletResponse response){
		response.addCookie(new Cookie("name", "val"));
		return "쿠키생성";
	}
	@RequestMapping(value = "/cookie/view")
	public @ResponseBody String view(@CookieValue(value = "name", defaultValue = "0") String ck){
		System.out.println(ck);
		return "쿠키 보여줌"+ck;
	}

}

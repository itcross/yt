package com.cross.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cross.model.Notice;
import com.cross.service.BoardDao;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private BoardDao boDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	/*
	@RequestMapping(value = "/") 
	public String home(Locale locale, Model model) {
		logger.info("welcome ! admin page");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "/admin/index";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String boardList(Model model) {
		return "/admin/manageUser";
	}*/
	
	//공지사항 리스트
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String noticeList(Model model) {
		return "/admin/managenotice";
	}
	
	//공지사항 글쓰기 action
	@RequestMapping(value = "/writen.do", method = RequestMethod.POST)
	public @ResponseBody String NoticeWrite(Model model,HttpSession session,@ModelAttribute Notice notice)throws Exception{
		System.out.println(notice);
		System.out.println(notice.getFile());
		System.out.println(notice.getN_chk());
		System.out.println(notice.getN_content());
		System.out.println(notice.getN_subject());
		System.out.println(notice.getUser_id());
		return "gg";
		/*String sessid = (String)session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView();
		if(sessid != null || sessid == "admin"){
			
			
		}else{
			mv.setViewName("/");
		}
		
		return "/admin/writenotice";*/
	}
	//공지사항 글쓰기 페이지
	@RequestMapping(value = "/writen", method = RequestMethod.GET)
	public String noticeWpage(Model model,HttpSession session)throws Exception{
		//String sessid = (String)session.getAttribute("user_id");
		//관리자가 아니고, 로그인이 아닐경우
		//if(sessid != "admin" || sessid == null ){
			//return "redirect:/"; //메인페이지 리다이렉트
		//}else{
			return "/admin/writenotice";			
		//}
	}
	/*
	@RequestMapping(value = "/viewnot", method = RequestMethod.GET)
	public String noticeView(Model model) {
		return "/admin/viewnotice";
	}
	
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faqList(Model model) {
		return "/admin/managefaq";
	}
	
	@RequestMapping(value = "/writef", method = RequestMethod.GET)
	public String faqWrite(Model model) {
		return "/admin/writefaq";
	}
	
	@RequestMapping(value = "/viewfaq", method = RequestMethod.GET)
	public String faqView(Model model) {
		return "/admin/viewfaq";
	}*/
}

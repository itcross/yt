package com.cross.admin;

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

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	//private BoardDao boDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
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
	}
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String noticeList(Model model) {
		return "/admin/managenotice";
	}
	
	@RequestMapping(value = "/writen", method = RequestMethod.GET)
	public String noticeWrite(Model model) {
		return "/admin/writenotice";
	}
	
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
	}
}

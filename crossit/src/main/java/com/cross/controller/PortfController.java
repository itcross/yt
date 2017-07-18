package com.cross.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cross.service.PortfDaoImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PortfController {
	
	@Autowired
	private PortfDaoImpl portfDao;
	
	private static final Logger logger = LoggerFactory.getLogger(PortfController.class);
	
	//전체 포트폴리오
	@RequestMapping(value = "/portlist", method = RequestMethod.GET)
	public String portList(Model model) {
		model.addAttribute("portl",portfDao.listPortf());
		return "portlist";
	}
	
	//개인 포트 이력
	@RequestMapping(value = "viewport",method=RequestMethod.GET)
	public String viewp(HttpSession session, Model model){
		
		
		return "portview";
	}
	
}

package com.cross.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cross.model.Resume;
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
	@RequestMapping(value = "/portview",method=RequestMethod.GET)
	public ModelAndView viewPort(@RequestParam String user_id,HttpSession session)throws Exception{

		ModelAndView mv = new ModelAndView();
		mv.setViewName("portview");
		mv.addObject("f", portfDao.viewPort(user_id));
		List<HashMap<String, Object>> l = portfDao.viewListinPortf(user_id);
		mv.addObject("l", l);
		System.out.println(l);
		return mv;
	}
	
	//포트폴리오 삭제
	@RequestMapping(value = "/portdel", method = RequestMethod.POST)
	public ModelAndView delPort(HttpSession session,@RequestParam String del){
		String sessid = (String)session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView();
		
		if(del == "y" && sessid != null){
			portfDao.deletePortf(session);
			mv.setViewName("portlist");
		}else{
			mv.setViewName("portview");
		}
		
		return mv;
	}
	
	//포트폴리오 등록 페이지

	@RequestMapping(value = "/portinst" , method = RequestMethod.GET)
	public ModelAndView regPortPage(HttpSession session){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("portinst");
		/*if(session.getAttribute("user_id") != null){
			mv.setViewName("portinst");
		}
		
		//세션이 없다면 글등록 권한 없음
		mv.setViewName("/main/login");*/
		return mv;
	}
	
	@RequestMapping(value = "portinsert.do" , method = RequestMethod.POST )
	public String insertPortf(){
		return null;
	}
}

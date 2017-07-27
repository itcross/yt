package com.cross.controller;

import java.text.DateFormat;
import java.util.ArrayList;
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

import com.cross.model.User;
import com.cross.service.RegiMybatisDAO;
import com.cross.service.UserDao;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final int listMax=10;//한 페이지에 띄울 list 갯수
	private static final int pageMax=10;//페이지 그룹에서 페이지의 갯수
	@Autowired
	private BoardDao boDao;

	private RegiMybatisDAO rDao;
	
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
	public String boardList(@RequestParam(value= "pageNum", required= false)String pageNum,Model model) {
		
		if(pageNum==null){
			pageNum="1";
		}
		
		int currentNum=Integer.parseInt(pageNum);
		int startRow = (currentNum-1)*listMax+1;
		int endRow = currentNum*listMax;
		
		int totalCnt=0;
		
		List<User> boardList=rDao.selectAllBoards();
		totalCnt=boardList.size();
		List<User> tmeList = new ArrayList<User>();
		
		
		if(totalCnt>0){
		int i=0;	
		if(totalCnt<endRow)
			endRow=totalCnt;
			
			while(true){// listMax의 크기만큼 받아옴.
				if(i>=(endRow-(currentNum-1)*10))
					break;	
			tmeList.add(boardList.get(startRow+i-1));
				i++;
			}
		}else
			tmeList = null;//////한페이지에 등록 할 수있는 리스트의 형태
		int pageGroupCount = totalCnt/(listMax*pageMax)+ ((totalCnt%listMax*pageMax)==0?0:1);//페이지 그룹의 갯수
		
		int pageGroupNum = (int)Math.ceil((double)currentNum/pageMax);//현재 페이지의  페이지 그룹 번호
		
		model.addAttribute("pageGroupNum", pageGroupNum);
		model.addAttribute("pageGroupCount", pageGroupCount);
		model.addAttribute("pageMax", pageMax);
		model.addAttribute("listMax", listMax );
		model.addAttribute("tmeList", tmeList);
		model.addAttribute("currentNum",currentNum);
		model.addAttribute("totalCnt", totalCnt);
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

/*package com.cross.controller;

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

import com.cross.model.Notice;
import com.cross.service.BoardDao;

*//**
 * Handles requests for the application home page.
 *//*
@Controller
public class BoardController {
	
	//�Խ��� ����
	@Autowired
	private BoardDao boDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET) //매칭 URL
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "index"; //jsp ?��?��
	}
	
	//게시?�� 리스?��(SELECT)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		
		List<HashMap<String, Object>> list = boDao.getList();
		model.addAttribute("list",list);
		return "boardlist"; //jsp ?��?��
	}
	
	//�? ?���?  ?��?���?
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String boardw() {
		return "regboard"; //jsp ?��?��
	}
	
	//게시?�� �??���?(INSERT)
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String boardInsert(@RequestParam String subject, @RequestParam String content, Model model) {
		try{
			Notice bo = new Notice();
			bo.setSubject(subject);
			bo.setContent(content);
			int n =  boDao.insertBo(bo);
			if(n != 0){
				System.out.println("?���? ?��?�� ?��?��");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "write";
	}
	
	//게시?�� �??��?��(SELECT)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boarddetail(Model model, @RequestParam int no) {
		System.out.println(no);
		HashMap<String, Object> map = boDao.getBoard(no);
		model.addAttribute("map" , map);
		return "viewBoard"; //jsp ?��?��
	}
	
	//
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String boardu(Model model, @RequestParam int no) {
		
		HashMap<String, Object> view = boDao.getBoard(no);
		model.addAttribute("view",view);
		return "regboard"; //jsp ?��?��
		
	}
	
	//게시?�� �? ?��?��(UPDATE)
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String boardUpdate(Model model , @RequestParam int no, @RequestParam String subject, @RequestParam String content) {
		
		try{
			Notice bo = new Notice();
			bo.setNo(no);
			bo.setSubject(subject);
			bo.setContent(content);
			int n = boDao.updateBo(bo);
			System.out.println(n);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "update"; //?��?�� jsp ?��?��(경고�?)
	}
	
	//게시?�� �? ?��?��(DELETE)
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteBoard(Model model, @RequestParam int no) {
		try{
			boDao.deleteBo(no); //?��?��?�� ?��?��
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "delete"; //?��?�� jsp ?��?��(경고�?)
	} 
	
}
*/
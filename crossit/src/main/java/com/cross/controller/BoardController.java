package com.cross.controller;

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

import com.cross.model.Board;
import com.cross.service.BoardDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardDao boDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET) //Îß§Ïπ≠ URL
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "index"; //jsp ?åå?ùº
	}
	
	//Í≤åÏãú?åê Î¶¨Ïä§?ä∏(SELECT)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		
		List<HashMap<String, Object>> list = boDao.getList();
		model.addAttribute("list",list);
		return "boardlist"; //jsp ?åå?ùº
	}
	
	//Í∏? ?ì±Î°?  ?éò?ù¥Ïß?
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String boardw() {
		return "regboard"; //jsp ?åå?ùº
	}
	
	//Í≤åÏãú?åê Í∏??ì±Î°?(INSERT)
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String boardInsert(@RequestParam String subject, @RequestParam String content, Model model) {
		try{
			Board bo = new Board();
			bo.setSubject(subject);
			bo.setContent(content);
			int n =  boDao.insertBo(bo);
			if(n != 0){
				System.out.println("?îîÎπ? ?†ï?ÉÅ ?ûÖ?†•");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "write";
	}
	
	//Í≤åÏãú?åê Í∏??ÉÅ?Ñ∏(SELECT)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boarddetail(Model model, @RequestParam int no) {
		System.out.println(no);
		HashMap<String, Object> map = boDao.getBoard(no);
		model.addAttribute("map" , map);
		return "viewBoard"; //jsp ?åå?ùº
	}
	
	//?àò?†ï ?éò?ù¥Ïß?
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String boardu(Model model, @RequestParam int no) {
		
		HashMap<String, Object> view = boDao.getBoard(no);
		model.addAttribute("view",view);
		return "regboard"; //jsp ?åå?ùº
		
	}
	
	//Í≤åÏãú?åê Í∏? ?àò?†ï(UPDATE)
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String boardUpdate(Model model , @RequestParam int no, @RequestParam String subject, @RequestParam String content) {
		
		try{
			Board bo = new Board();
			bo.setNo(no);
			bo.setSubject(subject);
			bo.setContent(content);
			int n = boDao.updateBo(bo);
			System.out.println(n);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "update"; //?ï¥?ãπ jsp ?ù¥?èô(Í≤ΩÍ≥†Ï∞?)
	}
	
	//Í≤åÏãú?åê Í∏? ?Ç≠?†ú(DELETE)
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteBoard(Model model, @RequestParam int no) {
		try{
			boDao.deleteBo(no); //?ç∞?ù¥?Ñ∞ ?Ç≠?†ú
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "delete"; //?ï¥?ãπ jsp ?ù¥?èô(Í≤ΩÍ≥†Ï∞?)
	} 
	
}

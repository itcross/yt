package com.cross.free;

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
public class HomeController {
	
	@Autowired
	private BoardDao boDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET) //매칭 URL
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "index"; //jsp 파일
	}
	
	//게시판 리스트(SELECT)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		
		List<HashMap<String, Object>> list = boDao.getList();
		model.addAttribute("list",list);
		return "boardlist"; //jsp 파일
	}
	
	//글 등록  페이지
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String boardw() {
		return "regboard"; //jsp 파일
	}
	
	//게시판 글등록(INSERT)
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String boardInsert(@RequestParam String subject, @RequestParam String content, Model model) {
		try{
			Board bo = new Board();
			bo.setSubject(subject);
			bo.setContent(content);
			int n =  boDao.insertBo(bo);
			if(n != 0){
				System.out.println("디비 정상 입력");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "write";
	}
	
	//게시판 글상세(SELECT)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String boarddetail(Model model, @RequestParam int no) {
		System.out.println(no);
		HashMap<String, Object> map = boDao.getBoard(no);
		model.addAttribute("map" , map);
		return "viewBoard"; //jsp 파일
	}
	
	//수정 페이지
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String boardu(Model model, @RequestParam int no) {
		
		HashMap<String, Object> view = boDao.getBoard(no);
		model.addAttribute("view",view);
		return "regboard"; //jsp 파일
		
	}
	
	//게시판 글 수정(UPDATE)
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
		return "update"; //해당 jsp 이동(경고창)
	}
	
	//게시판 글 삭제(DELETE)
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteBoard(Model model, @RequestParam int no) {
		try{
			boDao.deleteBo(no); //데이터 삭제
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "delete"; //해당 jsp 이동(경고창)
	} 
	
}

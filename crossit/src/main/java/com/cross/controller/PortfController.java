package com.cross.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cross.model.Image;
import com.cross.model.Portfo;
import com.cross.model.Resume;
import com.cross.model.Workskill;
import com.cross.service.PortfDaoImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PortfController {
	
	@Autowired
	private PortfDaoImpl portfDao;
	
	private static final Logger logger = LoggerFactory.getLogger(PortfController.class);
	
	@RequestMapping(value = "/portlist", method = RequestMethod.GET)
	public String portList(Model model) {
		model.addAttribute("portl",portfDao.listPortf());
		return "portlist";
	}
	
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
	
	@RequestMapping(value = "/portinst" , method = RequestMethod.GET)
	public ModelAndView regPortPage(HttpSession session){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("portinst");
		/*if(session.getAttribute("user_id") != null){
			mv.setViewName("portinst");
		}
		
		mv.setViewName("/main/login");*/
		return mv;
	} 
	
	//picture upload
	@RequestMapping(value = "portimgup" , method = RequestMethod.POST )
	public String img(MultipartHttpServletRequest m){
		String filePath = "C:/upload";
		File dir = new File(filePath);
		if(!dir.exists()){ //디렉토리가 없다면, 새로 생성
			dir.mkdirs();
		}

		HashMap<String, Object> h = new HashMap<String, Object>();
		List<MultipartFile> l = m.getFiles("upfile");
		List<String> filepathlist = new ArrayList<String>();
		for(int i = 0 ; i < l.size() ; i++){
			String fileName = l.get(i).getOriginalFilename();
			String uploadPath = "";
			if(fileName!=""){
				uploadPath = filePath+"/"+System.currentTimeMillis()+"_"+fileName; //업로드 경로
			}
			filepathlist.add(uploadPath);
			
			try{
				l.get(i).transferTo(new File(uploadPath)); //파일 업로드
				System.out.println("file successfully uploaded!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		h.put("pic1", filepathlist.get(0));
		h.put("pic2", filepathlist.get(1));
		h.put("pic3", filepathlist.get(2));

		//DB저장
		portfDao.inserPic(h);
		return "portinst";
	}
	
	
	//insert resume
	@RequestMapping(value = "/resumeInsert.do", method = RequestMethod.POST)
	public String insertResume(HttpSession session,@ModelAttribute("resume") Resume resume){
		/*if(session.getAttribute("user_id")!=null){
			
		}*/
		resume.setUser_id("a");  //세션아이디 등록(중복 불가)
		portfDao.createResume(resume); //db저장
		return "portinst";
	}
	
	@RequestMapping(value = "/portinsert.do", method = RequestMethod.POST)
	public String insertPf(HttpSession session,@ModelAttribute("workskill") Workskill wsk, 
			@ModelAttribute("portfo") Portfo pf,MultipartHttpServletRequest muRequest){
		/*if(session.getAttribute("user_id")!=null){
			
		}*/
		portfDao.createProj(pf);
		portfDao.createSkill(wsk);
		return "";
	}
}

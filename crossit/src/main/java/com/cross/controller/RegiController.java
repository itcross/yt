package com.cross.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cross.model.User;
import com.cross.service.RegiMybatisDAO;
import com.cross.util.MailService;

@Controller
@SessionAttributes("id")
public class RegiController {
	@Qualifier("rDao")
	@Autowired
	RegiMybatisDAO rDao;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value = "/registerform")
	public String register(Model model) {
	
		return "registerform";
	}
	@RequestMapping(value = "/registersuccess", method = RequestMethod.POST)
	public String registerform(@RequestParam String b_year,@RequestParam String b_month,@RequestParam String b_day,@RequestParam String email1,@RequestParam String email2,@RequestParam String c_gender,User uVo) {
		   DecimalFormat df = new DecimalFormat("00");
		   Calendar calendar = Calendar.getInstance();

		   String year = Integer.toString(calendar.get(Calendar.YEAR)); //년도를 구한다
		   String month = df.format(calendar.get(Calendar.MONTH) + 1); //달을 구한다
		   String day = df.format(calendar.get(Calendar.DATE)); //날짜를 구한다
		   
		   uVo.setReg_date(year+month+day);
		   uVo.setUser_birth(b_year+b_month+b_day);
		   uVo.setUser_email(email1+"@"+email2);
		   
		   if(c_gender.equals("남성"))
			   uVo.setUser_sex("M");
		   else
			   uVo.setUser_sex("F");
		   
		   rDao.insertRegi(uVo);
		
		return "registersuccess";
	}
	
	
	@RequestMapping(value = "/join_agree")
	public String registerAgree(Model model) {
	
		return "registerAgree";
	}

	@RequestMapping(value = "/idCheckform")
	public String idCheckform(Model model) {
    
	    return "checkId";
	}
	@RequestMapping(value = "/idCheck", method=RequestMethod.POST)
	@ResponseBody
	public String idCheck(@RequestParam (value= "id", required= false) String id) {


		String deliver;
		boolean check=rDao.idCheck(id);
		if(check==false){
			deliver="false";
		}
		else
			deliver="true";
		return deliver;
	}
	//회원 가입 인증
	@RequestMapping(value = "/regiMail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String sendMailAuth(HttpSession session, @RequestParam String email) {
		
	
		
        int ran = new Random().nextInt(100000) + 10000; // 10000 ~ 99999
        String joinCode = String.valueOf(ran);
        session.setAttribute("joinCode", joinCode);
 
        String subject = "회원가입 인증 코드 발급 안내 입니다.";
        StringBuilder sb = new StringBuilder();
        sb.append("귀하의 인증 코드는 " + joinCode + " 입니다.");
         boolean check=mailService.send(subject, sb.toString(), "lhb5759@gmail.com", email, null);
         if(check==true)
        	 return "true";
         else
        	 return "false";
	
	}
	@RequestMapping(value = "/regiMail_check", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String checkMailAuth(HttpSession session, @RequestParam String code) {
		
		String joincode=(String)session.getAttribute("joinCode");
		
		if(joincode.equals(code))
			return "true";
		else
			return "false";
	
	}
}

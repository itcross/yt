package com.cross.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.cross.model.Image;
import com.cross.model.Portfo;
import com.cross.model.Resume;
import com.cross.model.Workskill;

public interface PortfDao {
	
	//list total portfolio
	public List<Portfo> listPortf();
	
	//insert resume
	public void createResume(Resume rvo);
	//insert workskill in resume
	public void createSkill(Workskill wsk);
	//insert portfolio image in resume
	public void createPortImg(Image img);
	//insert project in resume
	public void createProj(Portfo pf);
	//register picture
	public void inserPic(HashMap<String, Object> h);
	
	public Resume viewPort(String user_id);
	
	public List<HashMap<String, Object>> viewListinPortf(String user_id);
	
	public int deletePortf(HttpSession session);
	
	public int updatePortf();
	
	public String isTempPortf(HttpSession session);

}

package com.cross.service;

import java.util.List;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import com.cross.model.Portfo;
import com.cross.model.Resume;

public interface PortfDao {
	
	//전체 포트폴리오 리스트
	public List<Portfo> listPortf();
	
	//포트폴리오 등록
	public int createPortf(HttpSession session);
	
	//포트폴리오 내용
	public Resume viewPort(String user_id);
	
	//포트폴리오 내 다중 리스트
	public List<HashMap<String, Object>> viewListinPortf(String user_id);
	
	//포트폴리오 삭제
	public int deletePortf(HttpSession session);
	
	//포트폴리오 수정
	public int updatePortf();
	
	//임시저장 판별
	public String isTempPortf(HttpSession session);
	

}

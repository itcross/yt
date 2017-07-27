package com.cross.service;

import java.util.List;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

import com.cross.model.Notice;
import com.cross.model.Portfo;
import com.cross.model.Resume;

public interface BoardDao {
	
	public int insertNotice(String sessid);
}

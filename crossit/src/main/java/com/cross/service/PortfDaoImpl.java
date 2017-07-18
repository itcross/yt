package com.cross.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cross.model.Portfo;
import com.cross.model.Resume;

@Repository
public class PortfDaoImpl implements PortfDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Portfo> listPortf() {
		return sqlSession.selectList("portsql.listPortf");
	}
	
	@Override
	public List<HashMap<String, Object>> viewListinPortf(String user_id) {
		List list = new ArrayList<HashMap<String, Object>>();
		list.add(sqlSession.selectList("portsql.viewSkill", user_id));
		list.add(sqlSession.selectList("portsql.viewImage", user_id));
		list.add(sqlSession.selectList("portsql.viewProj", user_id));
		return list;
	}
	
	@Override
	public int createPortf(HttpSession session) {
		String sessid = (String) session.getAttribute("user_id");
		return sqlSession.insert("portsql.regPortf",sessid);
	}
	@Override
	public Resume viewPort(String user_id) {
		return sqlSession.selectOne("portsql.viewPortf", user_id);
	}
	
	@Override
	public int deletePortf(HttpSession session) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updatePortf() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String isTempPortf(HttpSession session) {
		String sessid = (String) session.getAttribute("user_id");
		return sqlSession.selectOne("portsql.isTempPortf", sessid);
	}
}

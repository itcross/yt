package com.cross.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cross.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//find id
	public String findId(User user){
		return sqlSession.selectOne("usersql.selectUserId",user);
	}
	//find pwd
	public String findPwd(User user){
		return sqlSession.selectOne("usersql.selectUserPw", user);
	}
	//update temp pwd
	public void updateTempPwd(String temppwd){
		sqlSession.update("usersql.updateTempPw",temppwd);
	}
	
	
	//login
	@Override
	public User getUser(String user_id) {
		return (User)sqlSession.selectOne("usersql.getUserInfoById", user_id);
	}
}

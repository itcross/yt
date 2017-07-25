package com.cross.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cross.model.User;


public class RegiMybatisDAO {
	  @Autowired
	  private SqlSessionTemplate session;
	    
	  public List<User> selectAllBoards() {
			
			return session.selectList("selectAllBoards");//selectList의 첫번째 인자는 네임스페이스명.함수id명 두번째 인자는 파라미터 값 넘기기. 
				
	}

		public void insertRegi(User uVo) {
			// TODO Auto-generated method stub
			
				session.insert("MyRegister.insertRegi",uVo);
		}
		
		
		public boolean idCheck(String user_id) {//회원가입 중복 체크
			// TODO Auto-generated method stub
			
			
			
				String check= session.selectOne("MyRegister.idCheck", user_id);

				if(check==null){
					return false;
				}
				else{
					return true;
				}
		}
		
		public boolean loginCheck(String user_id,String user_pw) {
			// TODO Auto-generated method stub
			
			
				String db_pw=session.selectOne("loginCheck",user_id);
				if(db_pw==null)
					return false;
				else if(db_pw.equals(user_pw))
					return true;
				else 
					return false;
		}
	
}

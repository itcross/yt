package com.cross.board;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<HashMap<String, Object>> getList() {
		return sqlSession.selectList("sql.getList");
	}
	
	public HashMap<String, Object> getBoard(int no) {
		 return sqlSession.selectOne("sql.getBoard", no);
	}

	public int insertBo(Board bo) {
		return sqlSession.insert("sql.insertBo", bo);
	}
	
	public int updateBo(Board bo) {
		return sqlSession.update("sql.updateBo", bo);
	}
	
	public int deleteBo(int no) {
		return sqlSession.delete("sql.deleteBo", no);
	}
	
}

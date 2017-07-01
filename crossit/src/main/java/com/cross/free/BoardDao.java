package com.cross.free;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//게시판 리스트 조회
	public List<HashMap<String, Object>> getList() {
		return sqlSession.selectList("sql.getList");
	}
	
	//게시판 내용 조회
	public HashMap<String, Object> getBoard(int no) {
		 return sqlSession.selectOne("sql.getBoard", no);
	}
	
	
	//게시판 글 등록
	public int insertBo(Board bo) {
		return sqlSession.insert("sql.insertBo", bo);
	}
	
	//게시판 글 수정
	public int updateBo(Board bo) {
		return sqlSession.update("sql.updateBo", bo);
	}
	
	//게시판 글 삭제
	public int deleteBo(int no) {
		return sqlSession.delete("sql.deleteBo", no);
		
	}
	
}

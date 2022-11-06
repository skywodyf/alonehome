package com.example.final01.model.interior.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.final01.model.interior.dto.InteriorDTO;

@Repository
public class InteriorDAOImpl implements InteriorDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAttach(int intbno) {
		return sqlSession.selectList("interior.getAttach", intbno);
	}

	@Override
	public void addAttach(String fullName) {
		sqlSession.insert("interior.addAttach", fullName);

	}

	@Override
	public void updateAttach(String fullName, int intbno) {
		Map<String,Object> map = new HashMap<>();
		map.put("fullName", fullName);
		map.put("intbno", intbno);
		sqlSession.insert("interior.updateAttach", map);

	}

	@Override
	public void create(InteriorDTO dto) throws Exception {
		sqlSession.insert("interior.insert",dto);

	}

	@Override
	public void update(InteriorDTO dto) throws Exception {
		sqlSession.update("interior.update", dto);

	}

	@Override
	public void delete(int intbno) throws Exception {
		sqlSession.delete("interior.delete", intbno);

	}

	@Override
	public List<InteriorDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		Map<String,Object> map=new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("interior.listAll", map);

	}

	@Override
	public void increaseViewcnt(int intbno) throws Exception {
		sqlSession.update("interior.increaseViewcnt", intbno);

	}

	@Override
	public int countArticle() throws Exception {
		return sqlSession.selectOne("interior.countArticle");
	}

	@Override
	public InteriorDTO read(int intbno) throws Exception {
		return sqlSession.selectOne("interior.read", intbno);
	}
}

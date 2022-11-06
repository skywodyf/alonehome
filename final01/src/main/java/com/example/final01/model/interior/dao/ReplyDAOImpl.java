package com.example.final01.model.interior.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.final01.model.interior.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ReplyDTO> list(int intbno) {
		return sqlSession.selectList("reply.listReply", intbno);
	}

	@Override
	public int count(int intbno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(ReplyDTO dto) {
		sqlSession.insert("reply.insertReply", dto);

	}

}

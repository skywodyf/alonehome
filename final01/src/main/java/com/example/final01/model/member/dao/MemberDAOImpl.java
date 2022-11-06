package com.example.final01.model.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.final01.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(MemberDTO dto) {
		String name=sqlSession.selectOne("member.login_check", dto);
		return (name==null)?false : true;
	}

	@Override
	public MemberDTO viewMember(String user_email) {
		return sqlSession.selectOne("member.viewMember", user_email);
	}

	@Override
	public Object insertMember(MemberDTO dto) {
		return sqlSession.insert("member.insert", dto);
	}

	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public boolean checkPw(String user_email, String user_pwd) {
		boolean result=false;
		Map<String,String> map=new HashMap<>();
		map.put("user_email", user_email);
		map.put("user_pwd", user_pwd);
		int count=sqlSession.selectOne("member.checkPw", map);
		//비번맞으면(1), 틀리면(0)
		if(count==1) result=true;
		return result;
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("member.updateMember", dto);
	}

	@Override
	public void deleteMember(String user_email) {
		sqlSession.selectOne("member.deleteMember", user_email);
	}

}

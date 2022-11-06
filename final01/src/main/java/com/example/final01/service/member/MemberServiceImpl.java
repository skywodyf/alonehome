package com.example.final01.service.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.final01.model.member.dao.MemberDAO;
import com.example.final01.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;
	
	@Override
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		boolean result=memberDao.loginCheck(dto);
		if(result) { //로그인성공
			MemberDTO dto2=viewMember(dto.getUser_email());
			session.setAttribute("user_email",dto.getUser_email());
			session.setAttribute("user_name", dto2.getUser_name());
			System.out.println(session.getAttribute("user_email"));
			System.out.println(session.getAttribute("user_name"));
		}
		return result;
	}

	@Override
	public void logout(HttpSession sesseion) {
		//세션 초기화
		sesseion.invalidate();
	}

	@Override
	public MemberDTO viewMember(String user_email) {
		return memberDao.viewMember(user_email);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);
	}

	@Override
	public List<MemberDTO> list() {
		return memberDao.list();
	}

	@Override
	public boolean checkPw(String user_email, String user_pwd) {
		return memberDao.checkPw(user_email,user_pwd);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);
	}

	@Override
	public void deleteMember(String user_email) {
		memberDao.deleteMember(user_email);
	}

}

package com.example.final01.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.final01.model.member.dto.MemberDTO;

public interface MemberService {
	public boolean loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession sesseion);
	public MemberDTO viewMember(String user_email);
	public void insertMember(MemberDTO dto);
	public List<MemberDTO> list();
	public boolean checkPw(String user_email, String user_pwd);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String user_email);
}

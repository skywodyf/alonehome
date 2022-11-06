package com.example.final01.model.member.dao;

import java.util.List;

import com.example.final01.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean loginCheck(MemberDTO dto);
	public MemberDTO viewMember(String user_email);
	public Object insertMember(MemberDTO dto);
	public List<MemberDTO> list();
	public boolean checkPw(String user_email, String user_pwd);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String user_email);
}

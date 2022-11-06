package com.example.final01.model.member.dto;

import java.util.Date;

public class MemberDTO {
	private String user_name; //이름
	private String user_email; //이메일
	private String user_sname; //닉네임
	private String user_pwd; //비밀번호
	private String user_phone; //핸드폰번호
	private Date join_date; //가입날짜
	//getter, setter, toString, 기본생성자
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_sname() {
		return user_sname;
	}
	public void setUser_sname(String user_sname) {
		this.user_sname = user_sname;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	@Override
	public String toString() {
		return "MemberDTO [user_name=" + user_name + ", user_email=" + user_email + ", user_sname=" + user_sname
				+ ", user_pwd=" + user_pwd + ", user_phone=" + user_phone + ", join_date=" + join_date + "]";
	}
	public MemberDTO() {

	}
	
	
	
}

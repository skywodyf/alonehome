package com.example.final01.model.interior.dto;

import java.util.Date;

public class ReplyDTO {
	private int intrno; //--댓글번호
	private int intbno; //--게시물번호
	private String intreplytext; // --댓글내용
	private String intreplyer; // --댓글작성자
	private Date intregdate; // --댓글작성일자
	private Date updatedate; // -- 댓글수정일자
	private String writer;//member 테이블의 id
	private String sname; //member 작성 닉네임
	//getter,setter,toString
	public int getIntrno() {
		return intrno;
	}
	public void setIntrno(int intrno) {
		this.intrno = intrno;
	}
	public int getIntbno() {
		return intbno;
	}
	public void setIntbno(int intbno) {
		this.intbno = intbno;
	}
	public String getIntreplytext() {
		return intreplytext;
	}
	public void setIntreplytext(String intreplytext) {
		this.intreplytext = intreplytext;
	}
	public String getIntreplyer() {
		return intreplyer;
	}
	public void setIntreplyer(String intreplyer) {
		this.intreplyer = intreplyer;
	}
	public Date getIntregdate() {
		return intregdate;
	}
	public void setIntregdate(Date intregdate) {
		this.intregdate = intregdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "ReplyDTO [intrno=" + intrno + ", intbno=" + intbno + ", intreplytext=" + intreplytext + ", intreplyer="
				+ intreplyer + ", intregdate=" + intregdate + ", updatedate=" + updatedate + ", writer=" + writer
				+ ", sname=" + sname + "]";
	}
	
}

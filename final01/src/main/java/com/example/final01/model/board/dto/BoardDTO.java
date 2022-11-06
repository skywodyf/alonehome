package com.example.final01.model.board.dto;

import java.util.Arrays;
import java.util.Date;

public class BoardDTO {
    private int id;//--게시물번호
    private String member_id;
    private String title;//--제목
    private String content;//--본문
    private Date reg_date;//--작성일자
    private String sname;// 닉네임
    private int view_cnt;//--조회수
    private int comment_cnt; //댓글 갯수
    private String show_YN; //화면 표시 여부
    private String[] files; //첨부파일 이름 배열
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public int getComment_cnt() {
		return comment_cnt;
	}
	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}
	public String getShow_YN() {
		return show_YN;
	}
	public void setShow_YN(String show_YN) {
		this.show_YN = show_YN;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", member_id=" + member_id + ", title=" + title + ", content=" + content
				+ ", reg_date=" + reg_date + ", sname=" + sname + ", view_cnt=" + view_cnt + ", comment_cnt="
				+ comment_cnt + ", show_YN=" + show_YN + ", files=" + Arrays.toString(files) + "]";
	}

    
}

package com.example.final01.model.interior.dto;

import java.util.Arrays;
import java.util.Date;

public class InteriorDTO {
			private int intbno;//--게시물번호
			private String inttitle;//--제목
			private String intcontent;//--본문
			private String intwriter;//--작성자
			private Date intregdate;//--작성일자
			private int intviewcnt;//--조회수
			private String sname; //작성자 닉네임
			private int cnt; //댓글 갯수
			private String show; //화면 표시 여부
			private String[] files; //첨부파일 이름 배열
			//getter,setter,toString
			public int getIntbno() {
				return intbno;
			}
			public void setIntbno(int intbno) {
				this.intbno = intbno;
			}
			public String getInttitle() {
				return inttitle;
			}
			public void setInttitle(String inttitle) {
				this.inttitle = inttitle;
			}
			public String getIntcontent() {
				return intcontent;
			}
			public void setIntcontent(String intcontent) {
				this.intcontent = intcontent;
			}
			public String getIntwriter() {
				return intwriter;
			}
			public void setIntwriter(String intwriter) {
				this.intwriter = intwriter;
			}
			public Date getIntregdate() {
				return intregdate;
			}
			public void setIntregdate(Date intregdate) {
				this.intregdate = intregdate;
			}
			public int getIntviewcnt() {
				return intviewcnt;
			}
			public void setIntviewcnt(int intviewcnt) {
				this.intviewcnt = intviewcnt;
			}
			public String getSname() {
				return sname;
			}
			public void setSname(String sname) {
				this.sname = sname;
			}
			public int getCnt() {
				return cnt;
			}
			public void setCnt(int cnt) {
				this.cnt = cnt;
			}
			public String getShow() {
				return show;
			}
			public void setShow(String show) {
				this.show = show;
			}
			public String[] getFiles() {
				return files;
			}
			public void setFiles(String[] files) {
				this.files = files;
			}
			@Override
			public String toString() {
				return "interiorDTO [intbno=" + intbno + ", inttitle=" + inttitle + ", intcontent=" + intcontent
						+ ", intwriter=" + intwriter + ", intregdate=" + intregdate + ", intviewcnt=" + intviewcnt
						+ ", sname=" + sname + ", cnt=" + cnt + ", show=" + show + ", files=" + Arrays.toString(files)
						+ "]";
			}
			
}

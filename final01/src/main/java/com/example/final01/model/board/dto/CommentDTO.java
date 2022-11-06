package com.example.final01.model.board.dto;

import java.util.Date;

public class CommentDTO {
    private int id; //게시물번호
    private int board_id; //게시물번호
    private String member_id; // 댓글작성자
    private String content;
    private String show_YN;
    private Date reg_date;
    private Date update_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShow_YN() {
        return show_YN;
    }

    public void setShow_YN(String show_YN) {
        this.show_YN = show_YN;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", board_id=" + board_id +
                ", member_id='" + member_id + '\'' +
                ", content='" + content + '\'' +
                ", show_YN='" + show_YN + '\'' +
                ", reg_date=" + reg_date +
                ", update_date=" + update_date +
                '}';
    }
}

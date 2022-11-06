package com.example.final01.model.board.dao;

import com.example.final01.model.board.dto.CommentDTO;

import java.util.List;

public interface CommentDAO {
    public void create(CommentDTO dto) throws Exception; //댓글쓰기
    public List<CommentDTO> list(int board_id) throws Exception; //댓글목록
    public void update(CommentDTO dto) throws Exception; //댓글수정
    public void delete(int id) throws Exception; //댓글삭제
}

package com.example.final01.service.board;

import com.example.final01.model.board.dto.BoardDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BoardService {
    public void create(BoardDTO dto) throws Exception; //글쓰기
    public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//목록
    public List<BoardDTO> list_view();
    public int countArticle(String search_option, String keyword) throws Exception;//레코드 갯수 계산
    public BoardDTO read(int id) throws Exception;	//레코드 조회
    public void increaseViewcnt(int id, HttpSession session) throws Exception;//조회수 증가 처리
    public void update(BoardDTO dto) throws Exception; //글수정
    public void delete(int id) throws Exception; //글삭제

    public void addBoardAttach(String fullName); //첨부파일 저장
    public List<String> getBoardAttach(int id); //첨부파일 정보
    public void updateBoardAttach(String fullName, int id);//첨부파일 수정
    public void deleteFile(String fullName); //첨부파일 삭제
}

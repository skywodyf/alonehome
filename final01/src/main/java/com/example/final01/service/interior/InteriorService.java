package com.example.final01.service.interior;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.final01.model.interior.dto.InteriorDTO;

public interface InteriorService {
	public void deleteFile(String fullName); //첨부파일 삭제
	public List<String> getAttach(int intbno); //첨부파일 정보
	public void addAttach(String fullName); //첨부파일 저장
	public void updateAttach(String fullName, int intbno);//첨부파일 수정
	public void create(InteriorDTO dto) throws Exception; //글쓰기 
	public void update(InteriorDTO dto) throws Exception; //글수정
	public void delete(int intbno) throws Exception; //글삭제
	public List<InteriorDTO> listAll(String search_option, String keyword, int start, int end) throws Exception;//목록
	public void increaseViewcnt(int intbno, HttpSession session) throws Exception;//조회수 증가 처리
	public int countArticle() throws Exception;//레코드 갯수 계산 
	public InteriorDTO read(int intbno) throws Exception;	//레코드 조회
}

package com.example.final01.service.board;

import com.example.final01.model.board.dao.BoardDAO;
import com.example.final01.model.board.dto.BoardDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Inject
    BoardDAO boardDao;

    @Transactional
    @Override
    public void create(BoardDTO dto) throws Exception{
        boardDao.create(dto);
        String[] files=dto.getFiles();
        if(files==null) return;
        for(String name : files) {
            boardDao.addBoardAttach(name);
        }
    }

    @Override
    public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) throws Exception{
        return boardDao.listAll(search_option, keyword, start, end);
    }

    @Override
    public List<BoardDTO> list_view(){
        return boardDao.list_view();
    }

    @Override
    public BoardDTO read(int id) throws Exception{
        return boardDao.read(id);
    }

    @Override
    public int countArticle(String search_option, String keyword) throws Exception{
        return boardDao.countArticle(search_option, keyword);
    }

    @Override
    public void increaseViewcnt(int bno, HttpSession session) throws Exception{
        long update_time=0;
        if(session.getAttribute("update_time_"+bno) != null) {
            //최근에 조회수를 올린 시간
            update_time=(long) session.getAttribute("update_time_"+bno);
        }
        long current_time=System.currentTimeMillis();
        //일정시간이 경과한 후 조회수 증가 처리
        if(current_time - update_time > 5*1000) {//24*60*60*1000 (하루)
            boardDao.increaseViewcnt(bno);
            //조회수를 올린 시간 저장
            session.setAttribute("update_time_"+bno, current_time);
        }
    }

    @Transactional
    @Override
    public void update(BoardDTO dto) throws Exception{
        boardDao.update(dto);
        //attach테이블도 함께 수정
        String[] files = dto.getFiles();
        if(files == null) return;
        for(String name : files) {
            boardDao.updateBoardAttach(name, dto.getId());
        }
    }

    @Transactional
    @Override
    public void delete(int bno) throws Exception{
        boardDao.delete(bno);
    }

    // 첨부파일

    @Override
    public void addBoardAttach(String fullName){

    }

    @Override
    public List<String> getBoardAttach(int id){
        return boardDao.getBoardAttach(id);
    }

    @Override
    public void updateBoardAttach(String fullName, int id){

    }

    @Override
    public void deleteFile(String fullName){

    }
}

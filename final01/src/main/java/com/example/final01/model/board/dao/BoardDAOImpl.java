package com.example.final01.model.board.dao;

import com.example.final01.model.board.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Inject
    SqlSession sqlSession;

    @Override
    public void create(BoardDTO dto) throws Exception{
        sqlSession.insert("board.insert",dto);
    }

    @Override
    public List<BoardDTO> listAll(String search_option, String keyword, int start, int end) throws Exception{
        Map<String,Object> map=new HashMap<>();
        map.put("search_option", search_option);
        map.put("keyword", "%"+keyword+"%");
        map.put("start", start-1);
        map.put("end", end);
        return sqlSession.selectList("board.listAll", map);
    }

    @Override
    public List<BoardDTO> list_view(){
        return sqlSession.selectList("board.list_view");
    }

    @Override
    public int countArticle(String search_option, String keyword) throws Exception{
        Map<String,Object> map=new HashMap<>();
        map.put("search_option", search_option);
        map.put("keyword", "%"+keyword+"%");
        return sqlSession.selectOne("board.countArticle", map);
    }

    @Override
    public BoardDTO read(int id) throws Exception{
        return sqlSession.selectOne("board.read", id);
    }

    @Override
    public void increaseViewcnt(int id) throws Exception{
        sqlSession.update("board.increaseViewcnt", id);
    }

    @Override
    public void update(BoardDTO dto) throws Exception{
        sqlSession.update("board.update", dto);
    }

    @Override
    public void delete(int id) throws Exception{
        sqlSession.delete("board.delete", id);
    }

    @Override
    public void addBoardAttach(String fullName) {
        sqlSession.insert("board.addBoardAttach", fullName);
    }

    @Override
    public List<String> getBoardAttach(int id){
        return sqlSession.selectList("board.getBoardAttach", id);
    }

    @Override
    public void updateBoardAttach(String fullName, int id){
        Map<String,Object> map = new HashMap<>();
        map.put("fullName", fullName);
        map.put("intid", id);
        sqlSession.insert("board.updateBoardAttach", map);
    }

    @Override
    public void deleteFile(String fullName) {

    }
}

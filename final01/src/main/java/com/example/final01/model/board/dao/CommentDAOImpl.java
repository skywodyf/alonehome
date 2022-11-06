package com.example.final01.model.board.dao;

import com.example.final01.model.board.dto.CommentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO{

    @Inject
    SqlSession sqlSession;

    @Override
    public void create(CommentDTO dto) throws Exception{
        sqlSession.insert("comment.insert",dto);
    }

    @Override
    public List<CommentDTO> list(int board_id) throws Exception{
        return sqlSession.selectList("comment.list", board_id);
    }

    @Override
    public void update(CommentDTO dto) throws Exception{
        sqlSession.update("comment.update", dto);
    }

    @Override
    public void delete(int id) throws Exception{
        sqlSession.delete("comment.delete", id);
    }
}

package com.example.final01.service.board;

import com.example.final01.model.board.dao.CommentDAO;
import com.example.final01.model.board.dto.CommentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Inject
    CommentDAO commentDao;

    @Transactional
    @Override
    public void create(CommentDTO dto) throws Exception{
        commentDao.create(dto);
    }

    @Override
    public List<CommentDTO> list(int board_id) throws Exception{
        return commentDao.list(board_id);
    }

    @Transactional
    @Override
    public void update(CommentDTO dto) throws Exception{
        commentDao.update(dto);
    }

    @Transactional
    @Override
    public void delete(int id) throws Exception{
        commentDao.delete(id);
    }
}

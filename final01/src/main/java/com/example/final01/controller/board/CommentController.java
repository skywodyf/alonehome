package com.example.final01.controller.board;

import com.example.final01.model.board.dto.BoardDTO;
import com.example.final01.model.board.dto.CommentDTO;
import com.example.final01.service.board.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("comment/*")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Inject
    CommentService commentService;

    @RequestMapping("insert.do")
    public String register(@ModelAttribute CommentDTO dto, @RequestParam int board_id, HttpSession session) throws Exception{
        String member_id=(String)session.getAttribute("user_email");
        dto.setMember_id(member_id);;
        dto.setBoard_id(board_id);
        commentService.create(dto);
        return "redirect:/board/board_view.do/"+dto.getBoard_id();
    }

    @RequestMapping("update.do/{id}")
    public String update(@PathVariable int id, CommentDTO dto) throws Exception{
        if(dto != null) {
            dto.setId(id);
            commentService.update(dto);
        }
        return "redirect:/board/board_view.do/"+dto.getBoard_id();
    }

    @RequestMapping("delete.do/{id}")
    public String delete(@PathVariable int id, @RequestParam int board_id) throws Exception{
        commentService.delete(id);
        return "redirect:/board/board_view.do/"+board_id;
    }
}

package com.example.final01.controller.board;

import com.example.final01.model.board.dto.BoardDTO;
import com.example.final01.service.board.BoardService;
import com.example.final01.service.board.CommentService;
import com.example.final01.service.interior.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("board/*")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Inject
    BoardService boardService;

    @Inject
    CommentService commentService;

    @RequestMapping("board_list.do")
    public ModelAndView list(
            @RequestParam(defaultValue = "") String search_option,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int curPage)
            throws Exception {

        //레코드 갯수 계산
        int count=boardService.countArticle(search_option,keyword);
        //페이지 관련 설정
        Pager pager=new Pager(count, curPage);
        int start=pager.getPageBegin();
        int end=pager.getPageEnd();

        List<BoardDTO> list=boardService.listAll(search_option,keyword,start,end);

        Map<String, Object> map=new HashMap<>();
        map.put("count", count);//레코드의 갯수
        map.put("pager", pager); //페이지네이션을 위한 변수
        map.put("search_option", search_option);
        map.put("keyword", keyword);

        ModelAndView mav=new ModelAndView();
        mav.setViewName("board/board_list");//포워딩 뷰
        mav.addObject("map", map);
        mav.addObject("list_view", list);
        return mav;
    }

    @RequestMapping("board_write.do")
    public String write() {
        //글쓰기 폼 페이지로 이동
        return "board/board_write";
    }

    @RequestMapping("insert.do")
    public String register(@ModelAttribute BoardDTO dto, HttpSession session) throws Exception{
        String member_id=(String)session.getAttribute("user_email");
        dto.setMember_id(member_id);;
        boardService.create(dto);
        return "redirect:/board/board_list.do";
    }

    @RequestMapping("board_view.do/{id}")
    public ModelAndView view(@PathVariable int id, HttpSession session) throws Exception{
        boardService.increaseViewcnt(id, session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("board/board_view");
        mav.addObject("dto", boardService.read(id));
        mav.addObject("comment_list", commentService.list(id));
        return mav;
    }

    @RequestMapping("board_update.do/{id}")
    public ModelAndView board_update(@PathVariable int id, HttpSession session) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("board/board_update");
        mav.addObject("dto", boardService.read(id));
        return mav;
    }

    //게시물 내용 수정
    @RequestMapping("update.do/{id}")
    public String update(@PathVariable int id, BoardDTO dto) throws Exception{
        if(dto != null) {
            dto.setId(id);
            boardService.update(dto);
        }
        //수정 완료 후 상세 화면으로..
        return "redirect:/board/board_view.do/"+dto.getId();
    }

    @RequestMapping("delete.do/{id}")
    public String delete(@PathVariable int id) throws Exception{
        boardService.delete(id);
        return "redirect:/board/board_list.do";
    }

    //첨부파일 목록을 리턴
    @RequestMapping("get_board_attach/{id}")
    @ResponseBody
    public List<String> getAttach(@PathVariable int id){
        return boardService.getBoardAttach(id);
    }

}

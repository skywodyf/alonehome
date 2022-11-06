package com.example.final01.controller.interior;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.final01.model.interior.dto.ReplyDTO;
import com.example.final01.service.interior.ReplyService;


@RestController
@RequestMapping("reply/*")
public class ReplyController {
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	public void insert(ReplyDTO dto, HttpSession session) {
		String intreplyer=(String)session.getAttribute("user_name");
		dto.setIntreplyer(intreplyer);
		replyService.create(dto);
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(int intbno, ModelAndView mav) {
		List<ReplyDTO> list=replyService.list(intbno);//댓글 목록
		mav.setViewName("interior/reply_list");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("list_json.do")
	public List<ReplyDTO> list_json(int intbno){
		return replyService.list(intbno);
	}

}

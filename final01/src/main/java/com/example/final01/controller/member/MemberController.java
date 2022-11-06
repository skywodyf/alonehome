package com.example.final01.controller.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.final01.model.member.dto.MemberDTO;
import com.example.final01.service.member.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	//로그인페이지이동
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberDTO dto, HttpSession session) {
		//로그인성공
		boolean result=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) {//성공
			mav.setViewName("home");
		}else {//실패
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		//세션초기화
		memberService.logout(session);
		mav.setViewName("home");
		mav.addObject("message", "logout");
		return mav;
	}
	
	//회원가입페이지 이동
	@RequestMapping("write.do")
	public String write() {
		return "member/write";
	}
	
	//회원정보저장
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberService.insertMember(dto);
		return "home";
	}
	
	//내정보보기
	@RequestMapping("view.do")
	public String view(@RequestParam String user_email, Model model) {
		model.addAttribute("dto", memberService.viewMember(user_email));
		return "member/view";
	}
	
	//회원수정
	@RequestMapping("update.do")
	public String update(MemberDTO dto, Model model) {
		boolean result=memberService.checkPw(dto.getUser_email(), dto.getUser_pwd());
		if(result) {
			memberService.updateMember(dto);
			return "home";
		}else {
			model.addAttribute("dto", dto);
			model.addAttribute("join_date", 
					memberService.viewMember(dto.getUser_email()).getJoin_date());
			model.addAttribute("message", "비밀번호를 확인하세요.");
			return "member/view";
		}
	}
	
	//회원삭제
	@RequestMapping("delete.do")
	public String delete(String user_email, String user_pwd, Model model) {
		boolean result=memberService.checkPw(user_email, user_pwd);
		if(result) {
			memberService.deleteMember(user_email);
			return "home";
		}else {
			model.addAttribute("message", "비밀번호가 틀렸습니다");
			model.addAttribute("dto",memberService.viewMember(user_email));
			return "member/view";
		}
	}
	//회원리스트
		@RequestMapping("list.do")
		public String memberList(Model model) {
			List<MemberDTO> list=memberService.list();
			model.addAttribute("list",list);
			return "member/member_list";
		}

}

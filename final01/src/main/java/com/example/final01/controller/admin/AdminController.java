 package com.example.final01.controller.admin;
 


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.final01.model.member.dto.MemberDTO;
import com.example.final01.service.admin.AdminService;


@Controller
@RequestMapping("admin/*")
public class AdminController {
	@Inject
	AdminService adminService;
	
	
	
	@RequestMapping("login.do")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberDTO dto, HttpSession session, 
			ModelAndView mav) {
		String name=adminService.loginCheck(dto);//로그인 체크
		if(name != null) {//로그인 성공
			//관리자용 세션변수
			session.setAttribute("admin_user_email", dto.getUser_email());
			session.setAttribute("admin_user_name", name);
			//일반사용자용 세션변수
			session.setAttribute("user_email", dto.getUser_email());
			session.setAttribute("user_name", name);
			mav.setViewName("admin/admin");//admin.jsp로 이동
		}else {//로그인 실패
			mav.setViewName("admin/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login.do";
	}
	
	
	
}

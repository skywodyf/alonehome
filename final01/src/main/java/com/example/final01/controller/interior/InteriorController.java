package com.example.final01.controller.interior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.final01.model.interior.dto.InteriorDTO;
import com.example.final01.service.interior.InteriorService;
import com.example.final01.service.interior.Pager;

@Controller
@RequestMapping("interior/*")
public class InteriorController {
	private static final Logger logger = LoggerFactory.getLogger(InteriorController.class);
	
	@Inject
	InteriorService interiorService;
	
	
	
	@RequestMapping("inte_list.do")
	public ModelAndView inte_list(
			@RequestParam(defaultValue = "intwriter") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int curPage) 
			throws Exception {
		
		//레코드 갯수 계산
		int count=interiorService.countArticle();
		//페이지 관련 설정
		Pager pager=new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		
		List<InteriorDTO> list=interiorService.listAll(search_option,keyword,start,end);
		logger.info(list.toString());
		ModelAndView mav=new ModelAndView();
		Map<String, Object> map=new HashMap<>();
		map.put("list", list);
		map.put("count", count);//레코드의 갯수
		map.put("pager", pager); //페이지네이션을 위한 변수
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		mav.setViewName("interior/inte_list");//포워딩 뷰
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("inte_write.do")
	public String inte_write() {
		//글쓰기 폼 페이지로 이동
		return "interior/inte_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute InteriorDTO dto, HttpSession session) throws Exception{
		String intwriter=(String)session.getAttribute("user_name");
		dto.setIntwriter(intwriter);
		interiorService.create(dto);
		return "redirect:/interior/inte_list.do";
	}
	
	@RequestMapping("inte_view.do")
	public ModelAndView inte_view(int intbno, HttpSession session) throws Exception{
		interiorService.increaseViewcnt(intbno, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/inte_view");
		mav.addObject("dto", interiorService.read(intbno));
		return mav;
	}
	
	//첨부파일 목록을 리턴
		@RequestMapping("getAttach/{intbno}")
		@ResponseBody
		public List<String> getAttach(@PathVariable int intbno){
			return interiorService.getAttach(intbno);
		}
		
		//게시물 내용 수정
		@RequestMapping("update.do")
		public String update(InteriorDTO dto) throws Exception{
			System.out.println("dto:"+dto);
			if(dto != null) {
				interiorService.update(dto);
			}
			//수정 완료 후 상세 화면으로..
			return "redirect:/interior/inte_view.do?intbno="+dto.getIntbno();
		}
		
		@RequestMapping("delete.do")
		public String delete(int intbno) throws Exception{
			interiorService.delete(intbno);
			return "redirect:/interior/inte_list.do";
		}
	
	
}

package com.example.final01.service.interior;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.final01.model.interior.dao.InteriorDAO;
import com.example.final01.model.interior.dto.InteriorDTO;

@Service
public class InteriorServiceImpl implements InteriorService {
	@Inject
	InteriorDAO interiorDao;
	
	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAttach(int intbno) {
		return interiorDao.getAttach(intbno);
	}

	@Override
	public void addAttach(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(String fullName, int intbno) {
		// TODO Auto-generated method stub

	}
	@Transactional
	@Override
	public void create(InteriorDTO dto) throws Exception{
		interiorDao.create(dto);
		String[] files=dto.getFiles();
		if(files==null) return;
		for(String name : files) {
			interiorDao.addAttach(name);
		}

	}
	@Transactional
	@Override
	public void update(InteriorDTO dto) throws Exception {
		interiorDao.update(dto);
		//attach테이블도 함께 수정
		String[] files = dto.getFiles();
		if(files == null) return;
		for(String name : files) {
			System.out.println("첨부파일 이름: " + name);
			interiorDao.updateAttach(name, dto.getIntbno());		
		}

	}
	@Transactional
	@Override
	public void delete(int intbno) throws Exception {
		interiorDao.delete(intbno);

	}

	@Override
	public List<InteriorDTO> listAll(String search_option, String keyword, int start, int end) throws Exception {
		return interiorDao.listAll(search_option, keyword, start, end);
	}

	@Override
	public void increaseViewcnt(int intbno, HttpSession session) throws Exception {
		long update_time=0;
		if(session.getAttribute("update_time_"+intbno) != null) {
			//최근에 조회수를 올린 시간
			update_time=(long) session.getAttribute("update_time_"+intbno);
		}
		long current_time=System.currentTimeMillis();
		//일정시간이 경과한 후 조회수 증가 처리
		if(current_time - update_time > 5*1000) {//24*60*60*1000 (하루)
			interiorDao.increaseViewcnt(intbno);
			//조회수를 올린 시간 저장
			session.setAttribute("update_time_"+intbno, current_time);
		}

	}

	@Override
	public int countArticle() throws Exception {
		return interiorDao.countArticle();
	}

	@Override
	public InteriorDTO read(int intbno) throws Exception {
		return interiorDao.read(intbno);
	}
}

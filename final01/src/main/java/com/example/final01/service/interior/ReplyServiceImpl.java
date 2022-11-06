package com.example.final01.service.interior;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.final01.model.interior.dao.ReplyDAO;
import com.example.final01.model.interior.dto.ReplyDTO;


@Service
public class ReplyServiceImpl implements ReplyService {
	@Inject
	ReplyDAO replyDao;

	@Override
	public List<ReplyDTO> list(int intbno) {
		return replyDao.list(intbno);
	}

	@Override
	public int count(int intbno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(ReplyDTO dto) {
		replyDao.create(dto);

	}

}

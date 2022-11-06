package com.example.final01.model.interior.dao;

import java.util.List;

import com.example.final01.model.interior.dto.ReplyDTO;


public interface ReplyDAO {
	
	public List<ReplyDTO> list(int intbno);
	public int count(int intbno);
	public void create(ReplyDTO dto);

}

package com.cy.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.MemDao;
import com.cy.dto.MemDto;

@Service
public class MemServiceImpl implements MemService{
	
	@Autowired
	private MemDao dao;

	@Override
	public MemDto loginYn(HashMap<String, String> param) {
		MemDto dto = dao.loginYn(param);
		
		return dto;
	}

	@Override
	public void write(HashMap<String, String> param) {
		dao.write(param);
	}

}
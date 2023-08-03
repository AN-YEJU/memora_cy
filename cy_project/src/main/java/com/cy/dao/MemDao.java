package com.cy.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.cy.dto.MemDto;

@Mapper
public interface MemDao {
	public MemDto loginYn(HashMap<String, String> param);
	
	public void write(HashMap<String, String> param);
}

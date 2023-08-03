package com.cy.service;

import java.util.HashMap;

import com.cy.dto.MemDto;

public interface MemService {
	public MemDto loginYn(HashMap<String, String> param);
	public void write(HashMap<String, String> param);
}

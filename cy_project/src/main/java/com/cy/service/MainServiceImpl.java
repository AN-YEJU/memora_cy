package com.cy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.MainDao;
import com.cy.dto.ContentDto;
import com.cy.dto.MainDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainServiceImpl implements MainService{
	
	@Autowired
	private MainDao dao;

	@Override
	public MainDto home(String id) {
		MainDto dto = dao.home(id);
		return dto;
	}

	@Override
	public void register(HashMap<String, String> param) {
		dao.register(param);
	}

	@Override
	public void modifyTitle(HashMap<String, String> param) {
		dao.modifyTitle(param);
	}
	
	@Override
	public void modifyContent(HashMap<String, String> param) {
		dao.modifyContent(param);
	}

	@Override
	public void modifyProfileImg(HashMap<String, String> param) {
		dao.modifyProfileImg(param);
	}

	@Override
	public void totalPlus(int mainId) {
		dao.totalPlus(mainId);
	}

	@Override
	public int today(int mainId) {
		return dao.today(mainId);
	}

	@Override
	public int total(int mainId) {
		return dao.total(mainId);
	}

	@Override
	public ArrayList<ContentDto> newList(String hostId) {
		log.info("@#@# newListService"+ dao.newList(hostId));
		return dao.newList(hostId);
	}

	@Override
	public int todayDiary(String hostId) {
		return dao.todayDiary(hostId);
	}

	@Override
	public int totalDiary(String hostId) {
		return dao.totalDiary(hostId);
	}

	@Override
	public int todayPhoto(String hostId) {
		return dao.todayPhoto(hostId);
	}

	@Override
	public int totalPhoto(String hostId) {
		return dao.totalPhoto(hostId);
	}

	@Override
	public int todayVisit(String hostId) {
		return dao.todayVisit(hostId);
	}

	@Override
	public int totalVisit(String hostId) {
		return dao.totalVisit(hostId);
	}
}

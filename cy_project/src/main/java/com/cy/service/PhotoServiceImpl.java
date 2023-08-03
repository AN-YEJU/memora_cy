package com.cy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.PhotoDao;
import com.cy.dto.Criteria;
import com.cy.dto.PhotoCategoryDto;
import com.cy.dto.PhotoCommentDto;
import com.cy.dto.PhotoDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoDao dao;
	
	@Override
	public ArrayList<PhotoDto> photo(Criteria cri) {
		ArrayList<PhotoDto> list = dao.photo(cri);
//		댓글을 리스트로 받는다
		for (int i = 0; i < list.size(); i++) {
			ArrayList<PhotoCommentDto> pcList = dao.pcList(list.get(i).getPhotoId());
			list.get(i).setPcList(pcList);
		}
		return list;
	}

	@Override
	public void photoWrite(HashMap<String, String> param) {
		log.info("$$$$$" + param);
		dao.photoWrite(param);
	}

	@Override
	public PhotoDto photoView(HashMap<String, String> param) {
		return dao.photoView(param);
	}
	
	@Override
	public void photoModify(HashMap<String, String> param) {
		dao.photoModify(param);
	}

	@Override
	public void photoDelete(HashMap<String, String> param) {
		dao.photoDelete(param);
	}

	@Override
	public ArrayList<PhotoCategoryDto> cateList(int mainId) {
		return dao.cateList(mainId);
	}
	
	@Override
	public void cateWrite(HashMap<String, String> param) {
		dao.cateWrite(param);
	}

	@Override
	public void cateModify(HashMap<String, String> param) {
		dao.cateModify(param);
	}

	@Override
	public void cateDelete(HashMap<String, String> param) {
		dao.cateDelete(param);
	}

	@Override
	public ArrayList<PhotoCommentDto> pcList(int diaryId) {
		return dao.pcList(diaryId);
	}

	@Override
	public void photoCommentWrite(HashMap<String, String> param) {
		dao.photoCommentWrite(param);
	}

	@Override
	public void photoCommentDelete(HashMap<String, String> param) {
		dao.photoCommentDelete(param);
	}

}

package com.cy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.DiaryDao;
import com.cy.dto.Criteria;
import com.cy.dto.DiaryCommentDto;
import com.cy.dto.DiaryDto;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryDao dao;
	
	@Override
	public ArrayList<DiaryDto> diary(Criteria cri) {
		ArrayList<DiaryDto> list = dao.diary(cri);
		
//		댓글을 리스트로 받는다
		for (int i = 0; i < list.size(); i++) {
			ArrayList<DiaryCommentDto> dcList = dao.dcList(list.get(i).getDiaryId());
			list.get(i).setDcList(dcList);
		}
		return list;
	}

	@Override
	public void diaryWrite(HashMap<String, String> param) {
		dao.diaryWrite(param);
	}

	@Override
	public DiaryDto diaryView(HashMap<String, String> param) {
		return dao.diaryView(param);
	}

	@Override
	public void diaryModify(HashMap<String, String> param) {
		dao.diaryModify(param);
	}

	@Override
	public void diaryDelete(HashMap<String, String> param) {
		dao.diaryDelete(param);
	}

	@Override
	public void diaryCommentWrite(HashMap<String, String> param) {
		dao.diaryCommentWrite(param);
	}

	@Override
	public void diaryCommentDelete(HashMap<String, String> param) {
		dao.diaryCommentDelete(param);
	}

}

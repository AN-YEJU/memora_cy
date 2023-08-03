package com.cy.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.dao.VisitDao;
import com.cy.dto.Criteria;
import com.cy.dto.VisitCommentDto;
import com.cy.dto.VisitDto;

@Service
public class VisitServiceImpl implements VisitService{

	@Autowired
	private VisitDao dao;
	
	@Override
	public ArrayList<VisitDto> visit(Criteria cri) {
		ArrayList<VisitDto> list = dao.visit(cri);
//		댓글을 리스트로 받는다
		for (int i = 0; i < list.size(); i++) {
			ArrayList<VisitCommentDto> vcList = dao.vcList(list.get(i).getVisitId());
			list.get(i).setVcList(vcList);
		}
		return list;
	}

	@Override
	public void visitWrite(HashMap<String, String> param) {
		dao.visitWrite(param);
	}

	@Override
	public void visitDelete(HashMap<String, String> param) {
		dao.visitDelete(param);
	}

	@Override
	public void visitCommentWrite(HashMap<String, String> param) {
		dao.visitCommentWrite(param);
	}

	@Override
	public void visitCommentDelete(HashMap<String, String> param) {
		dao.visitCommentDelete(param);
	}

}

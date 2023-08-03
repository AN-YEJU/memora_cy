package com.cy.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cy.dto.Criteria;
import com.cy.dto.VisitDto;

public interface VisitService {
	//방명록 목록 조회
    public ArrayList<VisitDto> visit(Criteria cri);

    //방명록 작성
    public void visitWrite(HashMap<String, String> param);

    //방명록 삭제
    public void visitDelete(HashMap<String, String> param);
    
    //다이어리 댓글 작성
    public void visitCommentWrite(HashMap<String, String> param);
    
    //다이어리 댓글 삭제
    public void visitCommentDelete(HashMap<String, String> param);
}

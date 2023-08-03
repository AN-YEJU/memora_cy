package com.cy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.cy.dto.Criteria;
import com.cy.dto.VisitCommentDto;
import com.cy.dto.VisitDto;

@Mapper
public interface VisitDao {
	//방명록 목록 조회
    public ArrayList<VisitDto> visit(Criteria cri);

    //방명록 작성
    public void visitWrite(HashMap<String, String> param);

    //방명록 삭제
    public void visitDelete(HashMap<String, String> param);
    
    //방명록 댓글 목록 조회
    public ArrayList<VisitCommentDto>vcList(int visitId);
    
    //방명록 댓글 작성
    public void visitCommentWrite(HashMap<String, String> param);
    
    //방명록 댓글 삭제
    public void visitCommentDelete(HashMap<String, String> param);
}

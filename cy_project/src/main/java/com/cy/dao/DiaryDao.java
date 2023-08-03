package com.cy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.cy.dto.Criteria;
import com.cy.dto.DiaryCommentDto;
import com.cy.dto.DiaryDto;

@Mapper
public interface DiaryDao {
	//다이어리 목록 조회
    public ArrayList<DiaryDto>diary(Criteria cri);

    //다이어리 작성
    public void diaryWrite(HashMap<String, String> param);

    //다이어리 수정 화면
    public DiaryDto diaryView(HashMap<String, String> param);

    //다이어리 수정
    public void diaryModify(HashMap<String, String> param);

    //다이어리 삭제
    public void diaryDelete(HashMap<String, String> param);
    
    //다이어리 댓글 목록 조회
    public ArrayList<DiaryCommentDto>dcList(int diaryId);
    
    //다이어리 댓글 작성
    public void diaryCommentWrite(HashMap<String, String> param);
    
    //다이어리 댓글 삭제
    public void diaryCommentDelete(HashMap<String, String> param);
}

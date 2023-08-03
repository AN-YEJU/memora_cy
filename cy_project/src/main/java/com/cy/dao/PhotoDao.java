package com.cy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.cy.dto.Criteria;
import com.cy.dto.PhotoCategoryDto;
import com.cy.dto.PhotoCommentDto;
import com.cy.dto.PhotoDto;

@Mapper
public interface PhotoDao {
	//사진첩 목록 조회
    public ArrayList<PhotoDto>photo(Criteria cri);

    //사진 등록
    public void photoWrite(HashMap<String, String> param);

    //사진 수정 화면
    public PhotoDto photoView(HashMap<String, String> param);
    
    //사진 수정
    public void photoModify(HashMap<String, String> param);

    //사진 삭제
    public void photoDelete(HashMap<String, String> param);
    
    //카테고리 목록
    public ArrayList<PhotoCategoryDto> cateList(int mainId);
    
    //카테고리 등록
    public void cateWrite(HashMap<String, String> param);
    
    //카테고리 수정
    public void cateModify(HashMap<String, String> param);
    
    //카테고리 삭제
    public void cateDelete(HashMap<String, String> param);
    
    //사진첩 댓글 목록 조회
    public ArrayList<PhotoCommentDto>pcList(int diaryId);
    
    //사진첩 댓글 작성
    public void photoCommentWrite(HashMap<String, String> param);
    
    //사진첩 댓글 삭제
    public void photoCommentDelete(HashMap<String, String> param);
}

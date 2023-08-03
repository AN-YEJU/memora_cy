package com.cy.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.cy.dto.ContentDto;
import com.cy.dto.DiaryDto;
import com.cy.dto.MainDto;

@Mapper
public interface MainDao {
	//메인화면 띄우기 용
    public MainDto home(String id);
    //홈페이지 등록
    public void register(HashMap<String, String> param);
    //제목 수정
    public void modifyTitle(HashMap<String, String> param);
    //프로필 소개 수정
    public void modifyContent(HashMap<String, String> param);
    //이미지 수정
    public void modifyProfileImg(HashMap<String, String> param);
    //토탈 증가
    public void totalPlus(int mainId);
    
    public int today(int mainId);
    
    public int total(int mainId);
    
    //최신순 글 4개 불러오기
    public ArrayList<ContentDto> newList(String hostId);
    
    //다이어리 new/total 불러오기
    public int todayDiary(String hostId);
    
    public int totalDiary(String hostId);
    
    //사진첩 new/total 불러오기
    public int todayPhoto(String hostId);
    
    public int totalPhoto(String hostId);
    
    //방명록 new/total 불러오기
    public int todayVisit(String hostId);
    
    public int totalVisit(String hostId);
}

package com.cy.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.cy.dto.ContentDto;
import com.cy.dto.DiaryDto;
import com.cy.dto.MainDto;

public interface MainService {
    public MainDto home(String id);

    public void register(HashMap<String, String> param);

    public void modifyTitle(HashMap<String, String> param);

    public void modifyContent(HashMap<String, String> param);
    
    public void modifyProfileImg(HashMap<String, String> param);
    //토탈 증가
    public void totalPlus(int mainId);
    
    public int today(int mainId);
    
    public int total(int mainId);
    
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

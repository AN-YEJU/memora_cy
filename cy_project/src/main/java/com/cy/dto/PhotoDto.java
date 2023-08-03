package com.cy.dto;

import java.sql.Date;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhotoDto {
	private int photoId; //사진첩 번호
	private String photoTitle; //사진제목
	private String photoCont;//사진용
	private Date photoDate;//등록날짜
	private String hostId;//아이디
	private String photoPath;//사진경로
	private int cateId; //카테고리번호
	private ArrayList<PhotoCommentDto> pcList;
	
	private String liker; 
	
	private int count;
}
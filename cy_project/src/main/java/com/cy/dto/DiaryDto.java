package com.cy.dto;

import java.sql.Timestamp;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiaryDto {
	private int diaryId; //다이어리번호
	private Timestamp diaryDate;//작성날짜
	private String diaryTitle;//제목
	private String diaryCont;//내용
	private String hostId;
	private ArrayList<DiaryCommentDto> dcList;
	
	private int count;
}
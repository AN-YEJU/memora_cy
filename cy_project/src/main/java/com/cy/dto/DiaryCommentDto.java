package com.cy.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiaryCommentDto {
//	댓글
	private int diaryNo; //다이어리 댓글번호
	private int diaryId; //다이어리번호
	private String commenter;//댓글 작성자
	private String comments;//댓글내용
	private Timestamp commentDate;//댓글날짜
}

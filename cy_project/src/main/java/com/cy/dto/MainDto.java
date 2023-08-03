package com.cy.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MainDto {
	private int mainID; //메인번호 PK
	private String id; //아이디
	private String mainTitle; //제목
	private String content; //컨텐츠
	private String profileImg; //프로필사진
	
	private Date totalDate; //방문자 수 관련
}

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
public class VisitCommentDto {
	private int visitId;
	private Timestamp commentDate;
	private String comments;//댓글내용
}
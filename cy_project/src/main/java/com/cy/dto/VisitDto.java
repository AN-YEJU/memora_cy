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
public class VisitDto {
	private int visitId;
	private String visitCont;
	private Date visitDate;
	private String hostId;
	private String guestId;
	
	private ArrayList<VisitCommentDto> vcList;
	
	private int count;
}
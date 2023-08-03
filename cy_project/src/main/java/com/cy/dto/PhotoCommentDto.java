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
public class PhotoCommentDto {
	private int photoNo;
	private String comments;
	private Timestamp commentDate;
	private String commenter;

	private int photoId;
}

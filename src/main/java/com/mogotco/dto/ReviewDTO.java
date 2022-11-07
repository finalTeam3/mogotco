package com.mogotco.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {
	private int reviewid;
	private int mentoringid;
	private String userid;
	private int rating;
	private String reviewcon;
	private Date reviewdate;
	
	private String mentor_userid;
}

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
	
	private int mentor_mentorid;
	private String mentor_userid;
	private int mcate_mcateid;
	private String mcate_mname;
	private String mentor_mentorimg;
	private String user_snsinsta;
	private String user_snsgit;
	
	//리뷰 전체 평점(choyunyoung add)
	private float avgrate;
}

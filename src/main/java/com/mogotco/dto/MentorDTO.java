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
public class MentorDTO {
	private int mentorid;
	private String userid;
	private String adminid;
	private String mentorcom;
	private String mentorcon;
	private String mentorimg;
	private String mcardimg;
	private int mentorok;
	private Date mentordate;
	private int cancelmentoring;
	private String mentorcareer;
	
	private String mcate_mname;
	private String mentoring_mtitle;
	private String mentoring_mentoringimg;
	private String mentoring_mentoringdate;
	private String review_userid;
	private String review_reviewcon;
}

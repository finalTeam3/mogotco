package com.mogotco.dto;

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
public class WishlistDTO {
	private int wishlistid;
	private String userid;
	private int mentorid;
	
	private String user_username;
	private String mentor_mentorimg;
	private String mentor_mentorcom;
	private String mentoring_mtitle;
	private String mentoring_mentoringimg;
	private String mentoring_mentoringdate;
}

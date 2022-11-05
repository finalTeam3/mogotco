package com.mogotco.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MentoringDTO {
	private int mentoringid;
	private int mentorid;
	private int mcateid;
	private int mentoringprice;
	private Date mentoringdate;
	private String mentoringimg;
	private String mentorurl;
	private int mmemberidcnt;
	private Date mrdate;
	private String mplace;
	private String mcontents;
	private String mtitle;
	private int mcaring;
	
	private String mentor_mentorcom;
	private String user_userid;
	
	
	
	
	

}

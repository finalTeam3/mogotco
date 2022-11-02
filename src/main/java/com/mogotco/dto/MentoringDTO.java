package com.mogotco.dto;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	
	
	

}

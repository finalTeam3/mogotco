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
	
	// 등록된 멘토링 리스트를 출력해주기 위한 dto추가
	private String mentor_mentorcom;
	private String user_userid;
	
	// 멘토링 옵션 화면 출력을 위한 dto추가
	private String mentor_mentorimg;
	private String mcate_mname;
	
	
	
	
	
	
	
	

}

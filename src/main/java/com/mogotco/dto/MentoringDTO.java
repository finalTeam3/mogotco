package com.mogotco.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
	
	@DateTimeFormat(pattern = "yy-MM-dd")
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
	private String user_userid;//멘토의 사용자 아이디임
	
	// 멘토링 옵션 화면 출력을 위한 dto추가
	private String mentor_mentorimg;
	private String mcate_mname;
	
	//지금 당장 롸잇나우 할 수 있는 멘토링
	private int date_difference;
	private String user_username;
	
	//리뷰 전체 평점(choyunyoung add)
	private float avgrate;
	// mentoring 대표 이미지를 위한 추가
	private MultipartFile mtrimg;
	
	
	
	
	
	
	
	

}

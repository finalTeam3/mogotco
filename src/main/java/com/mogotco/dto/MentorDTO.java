package com.mogotco.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

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
	private String mentorcom; // mentor company
	private String mentorcon; // mentor contents
	private String mentorimg;
	private String mcardimg;
	private int mentorok;
	private Date mentordate;
	private int cancelmentoring;
	private String mentorcareer;
	private Date mentorapply;
	private String mcardposition;
	
	private MultipartFile mpimg;  // mentor profile image
	private MultipartFile mcimg;  // mentor card image
	
	private String mentoring_mentoringid;
	private String mentoring_mtitle;
	private String mentoring_mentoringimg;
	private String mentoring_mentoringdate;
	private String mentoring_mplace;
	private String user_username;
	
	
}

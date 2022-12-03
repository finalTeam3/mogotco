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
public class MWishcateDTO {
	private int mwishcateid;
	private int mcateid;  // 희망 분야 id
	private int mentorid; // 희망 분야를 선택한 멘토의 테이블 id
	
	private String mcate_mname; // 희망 분야 이름
	private String mentor_userid;
	
	//mentorlist에서 cate선택했을 때 나오는 것
	//같은 이름의 객체에 넣어줘야 하기 때문에 이름에 _를 붙일수가 없음!
	private String mentorimg;
	private String userid;
	private String mentorcom;
}

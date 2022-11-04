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
}

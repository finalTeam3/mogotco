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
	private String userid; // 위시리스트에 멘토를 추가한 사용자 id
	private int mentorid;  // 위시리스트에 추가된 멘토 id
	
	// 여기서 user_username은 멘토의 이름이므로 user_mentorname으로 변경함
	private String user_mentorname;
	private String mentor_mentorimg;
	private String mentor_mentorcom;
}

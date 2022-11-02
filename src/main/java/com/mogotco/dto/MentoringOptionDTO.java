package com.mogotco.dto;

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
public class MentoringOptionDTO {
	private int moptionid;
	private int mentoringid;
	private String moptiontime;
	private int moptionstock;

}

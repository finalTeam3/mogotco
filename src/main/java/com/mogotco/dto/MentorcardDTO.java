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
public class MentorcardDTO {
	private int mcardid;
	private int mentorid;
	private String mcardcom;
	private String mcardname;
	private String mcardposition;
}

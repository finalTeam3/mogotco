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
	private int mcateid;
	private int mentorid;
	
	private String mcate_mname;
}

package com.mogotco.dto;

import java.util.Date;

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
public class UserDTO {
	private String userid;
	private String userpwd;
	private String username;
	private String useraddr;
	private String usertel;
	private String useremail;
	private Date userdate;
	private int withdraw;
	private Object userbirth;
	private int userpoint;
	private String naverid;
	private String kakaoid;
	private String googleid;
	private String usergen;
	private String addrnum;
	
	private int mentor_mentorok;
}

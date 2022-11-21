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
public class PurchaseDetailDTO {
	private int purchasedetailid;
	private int mentoringoptionid;
	private int purchaseid;
	private int cancelpur;
	private String progresspur;
	
	
	//구매이력페이지(멘토링이력)-(대면)구매번호,구매날짜,가격,결제방법,멘토링제목,멘토이름,멘토링 날짜,시간,현재 멘토링 멤버 명수 상황,대면장소, 진행여부,케어유무
	                    //(비대면)구매번호, 구매날짜, 가격, 결제빙밥, 멘토링제목, 멘토이름, 멘토링날짜, 현재 멘토링 멤버 수, 비대면영상 url, 진행여부,케어유무
	
	//구매번호,구매날짜,가격,결제방법,멘토링제목,멘토이름,멘토링 날짜,시간,대면장소, 진행여부,케어유무
	private Date purchase_purdate;
	private int purchase_purprice;
	private String purchase_purpay;
	private String purchase_purcard;
	private String mentoring_mtitle;
	private String user_mentorname;//멘토이름임 헷갈리지 않기 위해서 이름 바꿔놈
	private Date mentoring_mentoringdate;
	private String mentoringoption_mentoringtime;
	private String mentoring_mentorurl;
	private String mentoring_mplace;
	private int mentoring_mcaring;
	
	//현재 멘토링 멤버 상황
	private int mentoringmembercnt; //각 멘토링시간에 듣는 인원수
	
	
	

}

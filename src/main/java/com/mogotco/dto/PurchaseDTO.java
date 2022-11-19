package com.mogotco.dto;

import java.sql.Date;

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
public class PurchaseDTO {
	private int purchaseid;
	private String userid;
	private int purprice;
	private Date purdate;
	private String purpay;
	
	//구매페이지-멘토링번호, 멘토제목, 멘토이름, 멘토링날짜, 시간, 대면장소, 모집정원(멘토링 테이블에서 끌고오기), 가격(멘토링테이블에 있는 가격에서 x1을 함->controller에서)(purprice), 결제방법 입력칸  
	//구매완료페이지-멘토링번호, 멘토제목,멘토링날짜, 시간,대면장소,최종결제금액,구매날짜,결제방법
	private int mentoring_mentoringid;
	private String mentoring_mtitle;
	private String user_mentorname;
	private Date mentoring_mentoringdate;
	private String mentoringoption_mentoringtime;
	private String mentoring_mplace;
	private int mentoring_mmemberidcnt;
	
	//mentoringmember을 insert할 때 필요함(구매화면단에 있어야함(보이지 않은 상태로))
	private int mentoringoption_mentoringoptionid;
	
	//cust의 point값 가져오기
	private int user_userpoint;
	

}

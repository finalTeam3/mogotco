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
public class PurchaseDetailDTO {
	private int purchasedetailid;
	private int mentoringid;
	private int purchaseid;
	private int cancelpur;
	

}

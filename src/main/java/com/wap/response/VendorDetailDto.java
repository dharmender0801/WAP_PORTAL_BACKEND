package com.wap.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class VendorDetailDto {

	private String vendorName;
	private String postbackUrl;
	private String payout;
	private String dailyCapping;
	private String callbackLimit;
	private String status;
	private String share;
	private String serverKey;
	private String advId;
	private String cut;
	private String counter;
	private String operatorName;
	private String lpUrl;
	
	
}

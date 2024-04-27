package com.wap.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryRequest {

	private String serverKey;
	private String query;

}

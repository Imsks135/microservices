package com.cgi.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Order {
	
	@Id
	private String orderId;
	private String orderTotal;
	private String userId;
	private String orderDateTime;

}

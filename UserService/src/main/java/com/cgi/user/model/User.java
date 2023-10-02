package com.cgi.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class User {
	
	@Id
	private String userId;
	private String userName;
	private String password;
	private Long mobileNumber;

}

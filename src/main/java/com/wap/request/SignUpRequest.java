package com.wap.request;

import com.wap.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
	private String firstName;
	private String lastName;
	private String email;
	private Role role;
	private String password;
}
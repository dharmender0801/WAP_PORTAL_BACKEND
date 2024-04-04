package com.wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wap.request.SignUpRequest;
import com.wap.request.SigninRequest;
import com.wap.response.JwtAuthenticationResponse;
import com.wap.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
		return new ResponseEntity<JwtAuthenticationResponse>(authService.signin(request), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authService.signup(request));
	}

}

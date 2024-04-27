package com.wap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wap.model.ServiceContent;
import com.wap.service.ServiceContentService;

@RequestMapping("/service")
@RestController
public class ServiceDetailControler {
	@Autowired
	private ServiceContentService contentService;

	@GetMapping("/getServiceDetail")
	public ResponseEntity<List<ServiceContent>> getContentData() {
		return new ResponseEntity<List<ServiceContent>>(contentService.getContent(), HttpStatus.OK);
	}

	@PostMapping("/addServiceDetail")
	public ResponseEntity<ServiceContent> AddContentData(@RequestBody ServiceContent content) {
		return new ResponseEntity<ServiceContent>(contentService.AddContent(content), HttpStatus.OK);
	}

}

package com.wap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wap.service.ContentService;

@RestController
@RequestMapping("/api/content")
public class ContentController {
	@Autowired
	private ContentService contentService;

}

package com.wap.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wap.request.QueryRequest;
import com.wap.response.VendorDetailDto;
import com.wap.response.statusResponse;
import com.wap.service.ContentService;

@RestController
@RequestMapping("/api/content")
public class ContentController {
	@Autowired
	private ContentService contentService;

	@GetMapping("/test")
	public String testMethod() {
		return "This is Test Method ";
	}

	@PostMapping("/getVendors")
	public ResponseEntity<List<VendorDetailDto>> getVendorList(@RequestBody VendorDetailDto detailDto)
			throws SQLException {
		return new ResponseEntity<List<VendorDetailDto>>(contentService.getVendorList(detailDto), HttpStatus.OK);
	}

	@PostMapping("/updateQuery")
	public ResponseEntity<statusResponse> addVendor(@RequestBody QueryRequest detailDto) {
		return new ResponseEntity<statusResponse>(contentService.insert(detailDto), HttpStatus.OK);
	}

	@PostMapping("/getCpidDesc")
	public ResponseEntity<String> execute(@RequestBody QueryRequest detailDto) {
		return new ResponseEntity<String>(contentService.excute(detailDto), HttpStatus.OK);
	}
}

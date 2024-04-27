package com.wap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wap.model.ServiceContent;
import com.wap.respos.ServiceRepository;

@Service
public class ServiceContentService {

	@Autowired
	private ServiceRepository repository;

	public List<ServiceContent> getContent() {
		// TODO Auto-generated method stub
		return repository.findByStatus(true);
	}

	public ServiceContent AddContent(ServiceContent content) {
		// TODO Auto-generated method stub
		return repository.save(content);
	}

}

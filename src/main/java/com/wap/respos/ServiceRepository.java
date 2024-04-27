package com.wap.respos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wap.model.ServiceContent;

public interface ServiceRepository extends JpaRepository<ServiceContent, Long> {

	List<ServiceContent> findByStatus(boolean b);

}

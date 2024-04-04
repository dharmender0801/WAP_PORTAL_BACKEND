package com.wap.respos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wap.model.ServiceContent;

public interface ServiceRepository extends JpaRepository<ServiceContent, Long> {

}

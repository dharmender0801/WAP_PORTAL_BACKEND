package com.wap.respos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wap.model.serviceData;

public interface serviceDetailRepo extends JpaRepository<serviceData, Long> {

}

package com.wap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_detail")
public class serviceData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String operatorName;
	@Column
	private String route;
	@Column
	private String serverKey;
	@Column
	private String insertQuery;
	@Column
	private String updateQuery;
	@Column
	private String getQuery;
	@ManyToOne
	@JoinColumn(name = "service_content_id")
	private ServiceContent serviceContent;
}

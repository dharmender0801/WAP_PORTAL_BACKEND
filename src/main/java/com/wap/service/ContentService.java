package com.wap.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wap.db.DbConnectionManager;
import com.wap.request.QueryRequest;
import com.wap.response.VendorDetailDto;
import com.wap.response.statusResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContentService {
	@Autowired
	private DbConnectionManager dbConnectionManager;

	public List<VendorDetailDto> getVendorList(VendorDetailDto detailDto) throws SQLException {
		// TODO Auto-generated method stub

		return getEntityData(detailDto.getServerKey());
	}

	private List<VendorDetailDto> getEntityData(String serverKey) throws SQLException {
		List<VendorDetailDto> detailDtos = new ArrayList<>();
		Connection connection = dbConnectionManager.getConnection(serverKey);
		String query = "SELECT * FROM quiz2play_vendor_detail where operator_name='Kenya'";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			VendorDetailDto detailDto2 = new VendorDetailDto();
			detailDto2.setVendorName(resultSet.getString("vendor_name"));
			detailDto2.setAdvId(resultSet.getString("cp_id"));
			detailDto2.setCallbackLimit(resultSet.getString("callback_limit"));
			detailDto2.setCounter(resultSet.getString("counter"));
			detailDto2.setCut(resultSet.getString("cut"));
			detailDto2.setPostbackUrl(resultSet.getString("callback_url"));
			detailDto2.setLpUrl(resultSet.getString("lp_url"));
			detailDto2.setPayout(resultSet.getString("payout"));
			detailDto2.setStatus(resultSet.getString("status"));
			detailDtos.add(detailDto2);
		}
		return detailDtos;
	}

	public statusResponse insert(QueryRequest detailDto) {
		// TODO Auto-generated method stub
		log.info("This Is rquest :{}",detailDto);
		try {
			Connection connection = dbConnectionManager.getConnection(detailDto.getServerKey());
			Statement stmt = connection.createStatement();
			stmt.execute(detailDto.getQuery());
			return new statusResponse(200, "success");
		} catch (Exception e) {
			e.printStackTrace();
			return new statusResponse(500, "Internal Server Error !");
		}

	}

	public String excute(QueryRequest detailDto) {
		// TODO Auto-generated method stub
		try {
			Connection connection = dbConnectionManager.getConnection(detailDto.getServerKey());
			PreparedStatement statement = connection.prepareStatement(detailDto.getQuery());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getString("cp_id");
			}

		} catch (Exception e) {
			return "error";
		}
		return null;
	}

}

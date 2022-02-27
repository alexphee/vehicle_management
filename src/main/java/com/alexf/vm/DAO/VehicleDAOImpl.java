package com.alexf.vm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alexf.vm.api.Vehicle;
import com.alexf.vm.rowmapper.VehicleRowMapper;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Vehicle> loadVehicles() {
		
		String sql = "SELECT * FROM vehicles;";
		//get the data from db using jdbc
		List<Vehicle> theListOfVehicles = jdbcTemplate.query(sql, new VehicleRowMapper());
		return theListOfVehicles;
	}

}

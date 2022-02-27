package com.alexf.vm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.jdbc.core.RowMapper;

import com.alexf.vm.api.Vehicle;

public class VehicleRowMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException { // called for as many rows as i have in my db

		Vehicle vehicle = new Vehicle();
		vehicle.setId(rs.getInt("id"));
		String type = rs.getString("vehicle_type");
		vehicle.setVehicle_type(type);
		vehicle.setLicense_plate(rs.getString("license_plate"));
		vehicle.setEntry_time(rs.getTime("entry_time"));
		vehicle.setExit_time(rs.getTime("exit_time"));

		if (rs.getTime("exit_time") != null) {
			int mins = ToMinutes(rs.getTime("entry_time"), rs.getTime("exit_time"));

			vehicle.setFee(FeeCalculator(type, mins));
		}

		return vehicle;
	}

	private int ToMinutes(Time entime, Time extime) {

		@SuppressWarnings("deprecation")
		int entryhours = entime.getHours();
		@SuppressWarnings("deprecation")
		int entryminutes = entime.getMinutes();
		int entryminTotal = entryhours * 60 + entryminutes;

		@SuppressWarnings("deprecation")
		int exithours = extime.getHours();
		@SuppressWarnings("deprecation")
		int exitminutes = extime.getMinutes();
		int exitminTotal = exithours * 60 + exitminutes;

		int mins = exitminTotal - entryminTotal;

		return mins;
	}

	private int FeeCalculator(String type, int mins) {
		int fee = 0;
		int pasOverTime = 1;
		int truOverTime = 2;
		int busOverTime = 3;

		if (mins >= 0 && mins <= 30) {
			fee = 0;
		} else if (mins > 30 && mins <= 60) {
			switch (type) {
			case "Passenger":
				fee = 3;
				break;
			case "Truck":
				fee = 5;
				break;
			case "Bus":
				fee = 7;
				break;
			}
		} else if (mins > 60 && mins <= 120) {
			switch (type) {
			case "Passenger":
				fee = 5;
				break;
			case "Truck":
				fee = 9;
				break;
			case "Bus":
				fee = 16;
				break;
			}
		} else if (mins > 120 && mins <= 240) {
			switch (type) {
			case "Passenger":
				fee = 7;
				break;
			case "Truck":
				fee = 11;
				break;
			case "Bus":
				fee = 19;
				break;
			}
		} else if (mins > 240) {
			switch (type) {
			case "Passenger":
				fee = (((mins - 240) / 60) * pasOverTime) + 7;
				break;
			case "Truck":
				fee = (((mins - 240) / 60) * truOverTime) + 11;
				break;
			case "Bus":
				fee = (((mins - 240) / 60) * busOverTime) + 19;
				break;
			}

		}

		return fee;

	}
}

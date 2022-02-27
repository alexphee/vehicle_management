package com.alexf.vm.api;

import java.sql.Time;

public class Vehicle {
	
	private int id; 
	private String vehicle_type;
	private String license_plate;
	private Time entry_time;
	private Time exit_time;
	private int fee;
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public Time getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Time time) {
		this.entry_time = time;
	}
	public Time getExit_time() {
		return exit_time;
	}
	public void setExit_time(Time exit_time) {
		this.exit_time = exit_time;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicle_type=" + vehicle_type + ", license_plate=" + license_plate
				+ ", entry_time=" + entry_time + ", exit_time=" + exit_time + ", fee=" + fee + "]";
	}
	
}

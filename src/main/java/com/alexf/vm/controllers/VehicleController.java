package com.alexf.vm.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alexf.vm.DAO.VehicleDAO;
import com.alexf.vm.api.Vehicle;

@Controller
public class VehicleController {

	@Autowired
	private VehicleDAO vehicleDAO;

	@GetMapping("/showVehicle")
	public String showVehicleList(Model model) {

		// call dao method to get data
		List<Vehicle> vehicleList = vehicleDAO.loadVehicles();

		for (Vehicle tempVehicle : vehicleList) {
			System.out.println(tempVehicle);
		}

		model.addAttribute("vehicles", vehicleList);
		return "vehicle-list";
	}
}

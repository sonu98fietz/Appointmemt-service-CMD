package com.pratian.appointmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exception.VitalsAlreadyAddedException;
import com.pratian.appointmentservice.exception.VitalsNotFoundException;
import com.pratian.appointmentservice.service.IVitalsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class VitalsController {

	@Autowired
	private IVitalsService service;
	
	@GetMapping("/vitals")
	@Operation(summary = "To get the Vitals")
	public ResponseEntity<?> getTests(){
		ResponseEntity<?> response = null;
		try{
			response = new ResponseEntity<>(service.findVitalsDtos(), HttpStatus.OK);
		}
		catch(VitalsNotFoundException e){
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	@PostMapping("/addVitals")
	@Operation(summary = "To add vitals")
	public ResponseEntity<?> add(@RequestBody Vitals vitals)
	{
		ResponseEntity<?> response = null;
		try{
			response = new ResponseEntity<Vitals>(service.addVitals(vitals), HttpStatus.OK);
		}
		catch(VitalsAlreadyAddedException e){
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}

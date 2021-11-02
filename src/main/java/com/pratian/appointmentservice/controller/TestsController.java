package com.pratian.appointmentservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pratian.appointmentservice.entities.Tests;
import com.pratian.appointmentservice.exception.TestAlreadyAddedException;
import com.pratian.appointmentservice.exception.TestNotFoundException;
import com.pratian.appointmentservice.service.ITestsService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class TestsController {

	@Autowired
	private ITestsService service;
	
	@GetMapping("/test")
	@Operation(summary = "To get the Tests")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response = null;
		try{
			response = new ResponseEntity<>(service.viewTestsDtos(), HttpStatus.OK);
		}
		catch(TestNotFoundException e){
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/add")
	@Operation(summary = "To add Tests")
	public ResponseEntity<?> add(@RequestBody Tests tests)
	{
		ResponseEntity<?> response = null;
		try{
			response = new ResponseEntity<Tests>(service.addTests(tests), HttpStatus.OK);
		}
		catch(TestAlreadyAddedException e){
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping("/remove/{id}")
	@Operation(summary = "To remove Test by using id")
	public void delete(@PathVariable (value = "id") long id) {	
		try {
			service.removeTests(id);
		} catch (TestNotFoundException e) {
		 new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}
}

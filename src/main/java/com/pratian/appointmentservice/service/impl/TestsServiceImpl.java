package com.pratian.appointmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratian.appointmentservice.controller.dto.TestsDto;
import com.pratian.appointmentservice.entities.Tests;
import com.pratian.appointmentservice.exception.TestAlreadyAddedException;
import com.pratian.appointmentservice.exception.TestNotFoundException;
import com.pratian.appointmentservice.mapper.TestsMapper;
import com.pratian.appointmentservice.repository.TestsRepository;
import com.pratian.appointmentservice.service.ITestsService;


@Service
public class TestsServiceImpl implements ITestsService{

	@Autowired
	private TestsRepository repo;
	
	@Autowired
	private TestsMapper mapper;

	@Override
	public List<TestsDto> viewTestsDtos() throws TestNotFoundException {
		List<Tests> tests = new ArrayList<Tests>();
		tests= repo.findAll();
		TestsDto testsdto =new TestsDto();
		List<TestsDto> testsDto = new ArrayList<TestsDto>();
		for(Tests t: tests) {
			testsdto=mapper.convertToDto(t);
			testsDto.add(testsdto);
		}
		
		return testsDto;
	}

	@Override
	public Tests addTests(Tests tests) throws TestAlreadyAddedException {
		if(repo.existsById(tests.getTestId())) {
			throw new TestAlreadyAddedException("Tests already exist");
		}
		else {
			Tests tests2 = repo.saveAndFlush(tests);
			return tests2;
		}
	}

	@Override
	public void removeTests(long id) throws TestNotFoundException {
		if(repo.getTestsById(id)!= null) {
			repo.deleteById(id);
		}else {
			throw new TestNotFoundException("No Tests Found");
		}	
	}

}

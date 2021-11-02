package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.controller.dto.TestsDto;
import com.pratian.appointmentservice.entities.Tests;
import com.pratian.appointmentservice.exception.TestAlreadyAddedException;
import com.pratian.appointmentservice.exception.TestNotFoundException;

public interface ITestsService {

	public List<TestsDto> viewTestsDtos() throws TestNotFoundException;
	public Tests addTests(Tests tests) throws TestAlreadyAddedException;
	public void removeTests(long id) throws TestNotFoundException;
}

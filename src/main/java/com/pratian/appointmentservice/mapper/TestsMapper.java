package com.pratian.appointmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.pratian.appointmentservice.controller.dto.TestsDto;
import com.pratian.appointmentservice.entities.Tests;


@Mapper
public interface TestsMapper {

	@Mappings({
		@Mapping(target = "testName", source = "tests.testName")
	})
	TestsDto convertToDto(Tests tests);
}

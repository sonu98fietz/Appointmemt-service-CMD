package com.pratian.appointmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.pratian.appointmentservice.controller.dto.VitalsDto;
import com.pratian.appointmentservice.entities.Vitals;


@Mapper
public interface VitalsMapper {

	@Mappings({
		@Mapping(target = "ECG", source = "vitals.ECG"),
		@Mapping(target="temperature",source ="vitals.temperature"),
		@Mapping(target="diabetics",source ="vitals.diabeties"),
		@Mapping(target="respirationRate",source ="vitals.respirationRate")
	})
	VitalsDto convertToDto(Vitals vitals);
}

package com.pratian.appointmentservice.service;

import java.util.List;
import com.pratian.appointmentservice.controller.dto.VitalsDto;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exception.VitalsAlreadyAddedException;
import com.pratian.appointmentservice.exception.VitalsNotFoundException;

public interface IVitalsService {
	public List<VitalsDto> findVitalsDtos() throws VitalsNotFoundException;
	public Vitals addVitals(Vitals vitals) throws VitalsAlreadyAddedException;
}

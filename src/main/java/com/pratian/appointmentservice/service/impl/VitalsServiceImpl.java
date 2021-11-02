package com.pratian.appointmentservice.service.impl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratian.appointmentservice.controller.dto.VitalsDto;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exception.VitalsAlreadyAddedException;
import com.pratian.appointmentservice.exception.VitalsNotFoundException;
import com.pratian.appointmentservice.mapper.VitalsMapper;
import com.pratian.appointmentservice.repository.VitalsRepository;
import com.pratian.appointmentservice.service.IVitalsService;

@Service
public class VitalsServiceImpl implements IVitalsService {

	@Autowired
	private VitalsRepository repo;
	
	@Autowired
	private VitalsMapper mapper;

	@Override
	public List<VitalsDto> findVitalsDtos() throws VitalsNotFoundException {
		List<Vitals> vitals = new ArrayList<Vitals>();
		vitals= repo.findAll();
		VitalsDto vitalsdto =new VitalsDto();
		List<VitalsDto> vitalsDto = new ArrayList<VitalsDto>();
		for(Vitals v: vitals) {
			vitalsdto=mapper.convertToDto(v);
			vitalsDto.add(vitalsdto);
		}
		
		return vitalsDto;
	}

	@Override
	public Vitals addVitals(Vitals vitals) throws VitalsAlreadyAddedException {
		if(repo.existsById(vitals.getVitalsId())) {
			throw new VitalsAlreadyAddedException("Vitals already exist");
		}
		else {
			Vitals vitals2 = repo.saveAndFlush(vitals);
			return vitals2;
		}
	}

}

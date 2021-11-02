package com.pratian.appointmentservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VitalsDto {
	
	private long ECG;
	private long temperature;
	private long diabetics;
	private long respirationRate;
	
}

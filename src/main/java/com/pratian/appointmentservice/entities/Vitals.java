package com.pratian.appointmentservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Vitals {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vitalsId;
    private long ECG;
    private long temperature;
    private long diabeties;
    private long respirationRate;
}

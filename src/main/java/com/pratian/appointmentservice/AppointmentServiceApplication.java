package com.pratian.appointmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import com.pratian.appointmentservice.mapper.TestsMapper;
import com.pratian.appointmentservice.mapper.TestsMapperImpl;
import com.pratian.appointmentservice.mapper.VitalsMapper;
import com.pratian.appointmentservice.mapper.VitalsMapperImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "AppointmentService", version = "1.0", description = "API for Appointment Service"))
public class AppointmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentServiceApplication.class, args);
	}

	@Bean
	public TestsMapper getTestsMapper() {
		return new TestsMapperImpl();
	}
	@Bean
	public VitalsMapper getVitalsMapper() {
		return new VitalsMapperImpl();
	}
}

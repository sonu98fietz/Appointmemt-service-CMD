package com.pratian.appointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pratian.appointmentservice.entities.Vitals;

@Repository
public interface VitalsRepository extends JpaRepository<Vitals, Long>{

	@Query(value = "select v from Vitals v")
	public List<Vitals> getVitals();
}

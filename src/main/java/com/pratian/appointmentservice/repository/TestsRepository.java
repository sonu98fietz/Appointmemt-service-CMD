package com.pratian.appointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pratian.appointmentservice.entities.Tests;

@Repository
public interface TestsRepository extends JpaRepository<Tests, Long>{

	@Query(value = "select t from Tests t")
	public List<Tests> getTests();

	@Query(value = "select t from Tests t where t.testId = :id")
	public Tests getTestsById(@Param(value = "id") long id);
}


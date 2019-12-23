package com.example.varma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.varma.dto.ChartData;
import com.example.varma.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Override
	List<Project> findAll();

	@Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value " + "FROM project " + "GROUP BY stage")
	List<ChartData> getProjectStatus();
}
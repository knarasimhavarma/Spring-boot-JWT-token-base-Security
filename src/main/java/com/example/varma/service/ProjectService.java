package com.example.varma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.varma.dao.ProjectRepository;
import com.example.varma.dto.ChartData;
import com.example.varma.entity.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository proRepo;


	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> getAll() {
		return proRepo.findAll();
	}

	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}

}
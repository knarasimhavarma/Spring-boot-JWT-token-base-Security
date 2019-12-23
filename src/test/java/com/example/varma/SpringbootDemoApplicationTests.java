package com.example.varma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.varma.dao.ProjectRepository;
import com.example.varma.entity.Project;

@SpringBootTest
class SpringbootDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	ProjectRepository proRepo;

	@Test
	public void ifNewProjectSave_thenSuccess() {
		Project newProject = new Project("New Test Project", "completed", "Test Description");

		proRepo.save(newProject);
		// System.out.println(proRepo.findAll().size());

		// assertEquals(5, proRepo.findAll().size());

	}

}

package com.example.varma;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.varma.dao.ProjectRepository;
import com.example.varma.entity.Project;

@SpringBootTest
//@ContextConfiguration(classes = SpringbootDemoApplication.class)
@RunWith(SpringRunner.class)
//@DataJpaTest
@SqlGroup({
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { // "classpath:schema.sql",
	"classpath:data.sql" }),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = { "classpath:drop.sql" }) })
public class ProjectRepositoryIntegrationTest {

	@Autowired
	ProjectRepository proRepo;
	@Test
	public void ifNewProjectSave_thenSuccess() {
		Project newProject = new Project("New Test Project", "completed", "Test Description");

		proRepo.save(newProject);
		System.out.println(proRepo.findAll().size());

		assertEquals(13, proRepo.findAll().size());

	}
}

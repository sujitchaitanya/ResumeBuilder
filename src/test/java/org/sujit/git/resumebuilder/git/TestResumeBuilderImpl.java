package org.sujit.git.resumebuilder.git;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sujit.git.resumebuilder.app.ResumeBuilderApplication;
import org.sujit.git.resumebuilder.service.ResumeBuilderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ResumeBuilderApplication.class)
public class TestResumeBuilderImpl {
	
	private String userName;
	
	@Autowired
	ResumeBuilderService resumeBuilderService;

	@Before
	public void setUp() throws Exception {
		userName = "sujitchaitanya";
	}

	@Test
	public void testGetuser() {
		assertNotNull(resumeBuilderService.getuser(userName));
	}

	@Test
	public void testGetGitRepositries() {
		assertNotNull(resumeBuilderService.getGitRepositries(userName));
	}

	@Test
	public void testGetUserLanguages() {
		assertNotNull(resumeBuilderService.getUserLanguages(userName));
	}

}

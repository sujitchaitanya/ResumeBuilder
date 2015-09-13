package org.sujit.git.resumebuilder.service;

import java.util.Map;

import org.sujit.git.resumebuilder.model.GitRepositry;
import org.sujit.git.resumebuilder.model.GitUser;
import org.sujit.git.resumebuilder.model.UserInfo;

public interface ResumeBuilderService {
	public GitUser getuser(String userName);
	public Map<String, GitRepositry> getGitRepositries(String userName);
	public UserInfo getUserLanguages(String userName);
}

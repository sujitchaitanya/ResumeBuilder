package org.sujit.git.resumebuilder.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.sujit.git.resumebuilder.model.GitRepositry;
import org.sujit.git.resumebuilder.model.GitUser;
import org.sujit.git.resumebuilder.model.UserInfo;
import org.sujit.git.resumebuilder.service.ResumeBuilderService;

@Service
public class ResumeBuilderServiceImpl implements ResumeBuilderService {
	
	private static String GET_USER_INFO_URL = "https://api.github.com/users/{userName}";
	private static String GET_USER_REPO_URL = "https://api.github.com/users/{userName}/repos";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	@Cacheable("gitUser")
	public GitUser getuser(String userName) {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("userName", userName);
		return restTemplate.getForObject(GET_USER_INFO_URL, GitUser.class, urlVariables);
	}

	@Override
	@Cacheable("gitRepositries")
	public Map<String, GitRepositry> getGitRepositries(String userName) {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("userName", userName);
		Map<String, GitRepositry> gitRepositues = new HashMap<String, GitRepositry>();
		Arrays.stream(restTemplate.getForObject(GET_USER_REPO_URL, GitRepositry[].class, urlVariables))
			.forEach(repo -> gitRepositues.put(repo.getId(), repo));
		return gitRepositues;
	}

	@Override
	@Cacheable("userInfo")
	public UserInfo getUserLanguages(String userName) {
		UserInfo userInfo = new UserInfo();
		userInfo.setGitUser(getuser(userName));
		userInfo.setGitRepositries(getGitRepositries(userName));
		userInfo.getGitRepositries().forEach((repoId, repo) -> updateuserLanguages(userInfo.getLanguages() ,repo));
		return userInfo;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, Integer> getRepositryLangugaes(GitRepositry gitRepositry){
		return restTemplate.getForObject(gitRepositry.getLanguages_url(), Map.class);
	}
	
	private void updateuserLanguages(Map<String, Collection<String>> userLanguages, GitRepositry gitRepositry){
		getRepositryLangugaes(gitRepositry).forEach((language, bytes) -> {
			if(userLanguages.get(language) == null) {
				userLanguages.put(language, new ArrayList<String>());
			}
			userLanguages.get(language).add(gitRepositry.getId());
		});
	}

}

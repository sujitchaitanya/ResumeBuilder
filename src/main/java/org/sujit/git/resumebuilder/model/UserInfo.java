package org.sujit.git.resumebuilder.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserInfo {
	private GitUser gitUser;
	private Map<String, GitRepositry> gitRepositries = new HashMap<String, GitRepositry>();
	private Map<String, Collection<String>> languages = new HashMap<String, Collection<String>>();
	private String selLanguage;
	public GitUser getGitUser() {
		return gitUser;
	}
	public void setGitUser(GitUser gitUser) {
		this.gitUser = gitUser;
	}
	public Map<String, GitRepositry> getGitRepositries() {
		return gitRepositries;
	}
	public void setGitRepositries(Map<String, GitRepositry> gitRepositries) {
		this.gitRepositries = gitRepositries;
	}
	public Map<String, Collection<String>> getLanguages() {
		return languages;
	}
	public void setLanguages(Map<String, Collection<String>> languages) {
		this.languages = languages;
	}
	public String getSelLanguage() {
		return selLanguage;
	}
	public void setSelLanguage(String selLanguage) {
		this.selLanguage = selLanguage;
	}
}

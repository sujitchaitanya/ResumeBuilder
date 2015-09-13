package org.sujit.git.resumebuilder.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitRepositry {
	private String id;
	private String name;
	private String full_name;
	private GitUser owner;
	private String html_url;
	private String description;
	private String languages_url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public GitUser getOwner() {
		return owner;
	}
	public void setOwner(GitUser owner) {
		this.owner = owner;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguages_url() {
		return languages_url;
	}
	public void setLanguages_url(String languages_url) {
		this.languages_url = languages_url;
	}
}

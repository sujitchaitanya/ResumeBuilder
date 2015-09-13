package org.sujit.git.resumebuilder.model;

import java.util.Date;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitUser {
	private String login;
	private String id;
	private String avatar_url;
	private String gravatar_id;
	private String url;
	private String html_url;
	private String followers_url;
	private String repos_url;
	private String type;
	private String site_admin;
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	private String hireable;
	private String bio;
	private int public_repos;
	private int public_gists;
	private int followers;
	private int following;
	private Date created_at;
	private Date updated_at;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getGravatar_id() {
		return gravatar_id;
	}
	public void setGravatar_id(String gravatar_id) {
		this.gravatar_id = gravatar_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getFollowers_url() {
		return followers_url;
	}
	public void setFollowers_url(String followers_url) {
		this.followers_url = followers_url;
	}
	public String getRepos_url() {
		return repos_url;
	}
	public void setRepos_url(String repos_url) {
		this.repos_url = repos_url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSite_admin() {
		return site_admin;
	}
	public void setSite_admin(String site_admin) {
		this.site_admin = site_admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHireable() {
		return hireable;
	}
	public void setHireable(String hireable) {
		this.hireable = hireable;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public int getPublic_repos() {
		return public_repos;
	}
	public void setPublic_repos(int public_repos) {
		this.public_repos = public_repos;
	}
	public int getPublic_gists() {
		return public_gists;
	}
	public void setPublic_gists(int public_gists) {
		this.public_gists = public_gists;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}

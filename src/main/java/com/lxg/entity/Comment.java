package com.lxg.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userIp;
	private Integer blogId;
	private String content;
	private Date commentDate;
	private Integer state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Comment() {
		super();
	}
	public Comment(Integer id, String userIp, Integer blogId, String content, Date commentDate, Integer state) {
		super();
		this.id = id;
		this.userIp = userIp;
		this.blogId = blogId;
		this.content = content;
		this.commentDate = commentDate;
		this.state = state;
	}
	
}

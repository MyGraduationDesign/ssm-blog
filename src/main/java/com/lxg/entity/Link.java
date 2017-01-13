package com.lxg.entity;

import java.io.Serializable;

public class Link implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String linkName;
	private String linkUrl;
	private Integer orderNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Link() {
		super();
	}
	public Link(Integer id, String linkName, String linkUrl, Integer orderNo) {
		super();
		this.id = id;
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.orderNo = orderNo;
	}
	
	
}

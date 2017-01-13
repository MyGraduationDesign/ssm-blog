package com.lxg.entity;

import java.io.Serializable;

public class BlogType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String typeName;
	private Integer orderNo;
	
	private Integer blogCount; // ÊýÁ¿
	
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public BlogType() {
		super();
	}
	public BlogType(Integer id, String typeName, Integer orderNo) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.orderNo = orderNo;
	}
	
}

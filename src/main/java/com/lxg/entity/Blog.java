package com.lxg.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String summary;
	private Date releaseDate;
	private Integer clickHit;
	private Integer replyHit;
	private String content;
	private String contentNoTag; // 博客内容 无网页标签 Lucene分词用
	private BlogType blogType;
	private String keyWord;
	
	private Integer blogCount;
	private String releaseDateStr; // 发布日期字符串 只取年和月
	private List<String> imagesList=new LinkedList<String>(); // 博客里存在的图片 主要用于列表展示显示缩略图
	
	public List<String> getImagesList() {
		return imagesList;
	}
	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}
	public Integer getBlogCount() {
		return blogCount;
	}
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	public String getContentNoTag() {
		return contentNoTag;
	}
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public Integer getReplyHit() {
		return replyHit;
	}
	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Blog() {
		super();
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public Blog(Integer id, String title, String summary, Date releaseDate, Integer clickHit, Integer replyHit,
			String content, BlogType blogType, String keyWord) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.releaseDate = releaseDate;
		this.clickHit = clickHit;
		this.replyHit = replyHit;
		this.content = content;
		this.blogType = blogType;
		this.keyWord = keyWord;
	}
	

}

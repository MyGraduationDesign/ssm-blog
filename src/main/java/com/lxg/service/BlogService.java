package com.lxg.service;

import java.util.List;
import java.util.Map;

import com.lxg.entity.Blog;

public interface BlogService {
	public List<Blog> list(Map<String,Object> map);
	public Long getTotal(Map<String,Object> map);
	public Blog findById(Integer id);
	public Integer update(Blog blog); 
	public Integer add(Blog blog);
	public Integer delete(Integer id);
	public Blog getNextBlog(Integer id);
	public Blog getLastBlog(Integer id);
}

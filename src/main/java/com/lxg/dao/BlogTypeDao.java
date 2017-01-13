package com.lxg.dao;

import java.util.List;
import java.util.Map;

import com.lxg.entity.BlogType;

public interface BlogTypeDao {
	//查询所有博客类型 以及对应的博客数量
	public List<BlogType> countList();
	public BlogType findById(Integer id);
	public List<BlogType> list(Map<String,Object> map);
	public Long getTotal(Map<String,Object> map);
	public Integer add(BlogType blogType);
	public Integer update(BlogType blogType);
	public Integer delete(Integer id);
}

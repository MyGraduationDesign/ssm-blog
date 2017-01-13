package com.lxg.dao;

import java.util.List;
import java.util.Map;

import com.lxg.entity.Link;

public interface LinkDao {
	public int add(Link link);
	public int update(Link link);
	public Integer delete(Integer id);
	public Long getTotal(Map<String,Object> map);
	public List<Link> list(Map<String,Object> map);
}

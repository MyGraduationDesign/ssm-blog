package com.lxg.service;

import java.util.List;
import java.util.Map;

import com.lxg.entity.Link;

public interface LinkService {
	public int add(Link link);
	public int update(Link link);
	public Integer delete(Integer id);
	public Long getTotal(Map<String,Object> map);
	public List<Link> list(Map<String,Object> map);
}

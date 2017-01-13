package com.lxg.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.LinkDao;
import com.lxg.entity.Link;
import com.lxg.service.LinkService;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkDao linkDao;
	public int add(Link link) {
		return linkDao.add(link);
	}

	public int update(Link link) {
		return linkDao.update(link);
	}

	public Integer delete(Integer id) {
		return linkDao.delete(id);
	}

	public Long getTotal(Map<String, Object> map) {
		return linkDao.getTotal(map);
	}

	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

}

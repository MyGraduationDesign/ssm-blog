package com.lxg.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxg.dao.BlogDao;
import com.lxg.entity.Blog;
import com.lxg.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService{
	@Resource
	private BlogDao blogDao;
	public List<Blog> list(Map<String, Object> map) {
		return blogDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return blogDao.getTotal(map);
	}

	public Blog findById(Integer id) {
		// TODO Auto-generated method stub
		return blogDao.findById(id);
	}

	public Integer update(Blog blog) {
		return blogDao.update(blog);
	}

	public Integer add(Blog blog) {
		return blogDao.add(blog);
	}

	public Integer delete(Integer id) {
		return blogDao.delete(id);
	}

	public Blog getNextBlog(Integer id) {
		return blogDao.getNextBlog(id);
	}

	public Blog getLastBlog(Integer id) {
		return blogDao.getLastBlog(id);
	}

}

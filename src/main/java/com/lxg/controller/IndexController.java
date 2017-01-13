package com.lxg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxg.entity.Blog;
import com.lxg.entity.PageBean;
import com.lxg.service.BlogService;
import com.lxg.util.PageUtil;
import com.lxg.util.StringUtil;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Resource
	private BlogService blogService;
	
	@RequestMapping("/index")
	public String index(@RequestParam(value="page",required=false)String page,Model model,HttpServletRequest request) throws Exception{
		StringBuffer param=new StringBuffer();
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),8);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Blog> blogList=blogService.list(map);
		model.addAttribute("blogList", blogList);
		model.addAttribute("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 5, param.toString()));
		return "home";
	}
}

package com.lxg.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxg.entity.Blog;
import com.lxg.lucene.BlogIndex;
import com.lxg.service.BlogService;
import com.lxg.util.StringUtil;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;

	private BlogIndex blogIndex;
	
	@RequestMapping("/articles/{id}")
	public String details(Model model,@PathVariable("id")Integer id,HttpServletRequest request) throws Exception{
		Blog blog=blogService.findById(id);
		String keyWords=blog.getKeyWord();
		if(StringUtil.isNotEmpty(keyWords)){
			String arr[]=keyWords.split(" ");
			model.addAttribute("keyWords", StringUtil.filterWhite(Arrays.asList(arr)));
		}else{
			model.addAttribute("keyWords", null);
		}
		model.addAttribute("blog", blog);
		model.addAttribute("pageCode", this.genUpAndDownPageCode(blogService.getLastBlog(id),blogService.getNextBlog(id),request.getServletContext().getContextPath()));
		blog.setClickHit(blog.getClickHit()+1); // ���͵��������1
		blogService.update(blog);
		return "blog";
	}
	@RequestMapping("/q")
	public String search(Model model,@RequestParam(value="q",required=false)String q,@RequestParam(value="page",required=false)String page,HttpServletRequest request) throws Exception{
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		List<Blog> blogList=blogIndex.searchBlog(q.trim());
		Integer toIndex=blogList.size()>=Integer.parseInt(page)*10?Integer.parseInt(page)*10:blogList.size();
		model.addAttribute("blogList", blogList.subList((Integer.parseInt(page)-1)*10, toIndex));
		model.addAttribute("pageCode",this.genUpAndDownPageCode(Integer.parseInt(page), blogList.size(), q,10,request.getServletContext().getContextPath()));
		model.addAttribute("q", q);
		model.addAttribute("resultTotal",blogList.size());
		model.addAttribute("pageTitle","�����ؼ���'"+q+"'���ҳ��_Java��Դ����ϵͳ");
		return "result";
	}
	private String genUpAndDownPageCode(Integer page,Integer totalNum,String q,Integer pageSize,String projectContext){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		if(totalPage==0){
			return "";
		}else{
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager' >");
			if(page>1){
				pageCode.append("<li><a href='"+projectContext+"/blog/q.html?page="+(page-1)+"&q="+q+"'>��һҳ</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a href='#'>��һҳ</a></li>");
			}
			if(page<totalPage){
				pageCode.append("<li><a href='"+projectContext+"/blog/q.html?page="+(page+1)+"&q="+q+"'>��һҳ</a></li>");				
			}else{
				pageCode.append("<li class='disabled'><a href='#'>��һҳ</a></li>");				
			}
			pageCode.append("</ul>");
			pageCode.append("</nav>");
		}
		return pageCode.toString();
	}
	private String genUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null){
			pageCode.append("<p>��һƪ��û����</p>");
		}else{
			pageCode.append("<p>��һƪ<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}
		if(nextBlog==null||nextBlog.getId()==null){
			pageCode.append("<p>��һƪ��û����</p>");
		}else{
			pageCode.append("<p>��һƪ��<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
}

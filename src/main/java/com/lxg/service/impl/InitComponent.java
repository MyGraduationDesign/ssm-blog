package com.lxg.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.lxg.entity.BlogType;
import com.lxg.entity.Link;
import com.lxg.entity.User;
import com.lxg.service.BlogTypeService;
import com.lxg.service.LinkService;
import com.lxg.service.UserService;

@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		UserService userService=(UserService) applicationContext.getBean("userService");
		BlogTypeService blogTypeService=(BlogTypeService) applicationContext.getBean("blogTypeService");
		LinkService linkService=(LinkService) applicationContext.getBean("linkService");
		User user=userService.find();
		user.setPassword(null);
		List<BlogType> blogTypeCountList=blogTypeService.countList();
		List<Link> linkList=linkService.list(null);
		application.setAttribute("user", user);
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		application.setAttribute("linkList", linkList);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}

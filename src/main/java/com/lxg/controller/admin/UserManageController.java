package com.lxg.controller.admin;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lxg.entity.User;
import com.lxg.service.UserService;
import com.lxg.util.DateUtil;
import com.lxg.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/user")
public class UserManageController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/editPassword")
	public String editPassword(HttpServletResponse response,String newPassword) throws Exception{
		User user = new User();
		user.setPassword(newPassword);
		int resultTotal=userService.update(user);
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response,result);
		return null;
	}
	
	@RequestMapping("/find")
	public String find(HttpServletResponse response) throws Exception{
		User user=userService.find();
		JSONObject result=JSONObject.fromObject(user);
		ResponseUtil.write(response, result);
		return null;
	}
	@RequestMapping("/save")
	public String save(HttpServletResponse response,@RequestParam("imageFile") MultipartFile imageFile,User user,HttpServletRequest request) throws Exception{
		if(!imageFile.isEmpty()){
			String filePath=request.getServletContext().getRealPath("/");
			String imageName=DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			user.setImageName(imageName);
		}
		int resultTotal=userService.update(user);
		StringBuffer result=new StringBuffer();
		if(resultTotal>0){
			result.append("<script language='javascript'>alert('修改成功！');</script>");
		}else{
			result.append("<script language='javascript'>alert('修改失败！');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/logout")
	public String logout() throws Exception{
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
}

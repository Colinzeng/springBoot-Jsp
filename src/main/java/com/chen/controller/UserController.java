package com.chen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.pojo.User;
import com.chen.service.UserServiceImpl;

@Controller
@RequestMapping("/userInfo")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * 注册用户
	 * @return
	 */
	@RequestMapping("/reg")
	public String reg(HttpServletRequest request){
		User user = new User();
		user.setUserName(request.getParameter("user"));
		user.setPassWord(request.getParameter("psw"));
		user.setCellphone(request.getParameter("phone"));
		int result = userServiceImpl.insert(user);
		if (result == 1) {
			request.setAttribute("success", "注册成功");
			request.getSession().setAttribute("username",user.getUserName());
			return "redirect:/";
		} else {
			request.setAttribute("error", "●︿●用户名已存在，请重新注册！");
			return "register";
		}
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		User user = new User();
		user.setUserName(request.getParameter("user"));
		user.setPassWord(request.getParameter("psw"));
		User u = userServiceImpl.findUser(user);
		if (u == null) {
			request.setAttribute("error","用户名或密码错误");
			return "login";
		} else {
			request.getSession().setAttribute("username",user.getUserName());
			return "index";
		}
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request){
		request.getSession().removeAttribute("username");
//		response.sendRedirect(request.getHeader("Referer"));
		return "index";
	}
	
}

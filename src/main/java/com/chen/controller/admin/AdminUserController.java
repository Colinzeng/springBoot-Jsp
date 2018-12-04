package com.chen.controller.admin;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.pojo.User;
import com.chen.service.UserServiceImpl;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * 登录后台管理
	 * @return
	 */
	@RequestMapping("/contrologin")
	public String contrologin(HttpServletRequest request){
		User user = new User();
		user.setUserName(request.getParameter("user"));
		user.setPassWord(request.getParameter("psw"));
		User u = userServiceImpl.findUser(user);
		if (u == null) {
			request.setAttribute("error", "用户名或密码错误");
			return  "admin/adminlogin";
		} else {
			return  "admin/admin";
		}
	}
	
	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<User> listuser = userServiceImpl.getAll();
		request.getSession().setAttribute("listuser", listuser);
		return "admin/userlist";
	}
	
	/**
	 * 搜索
	 * @return
	 */
	@RequestMapping("/fuzzy")
	public String fuzzy(HttpServletRequest request){
		
		String un = request.getParameter("un");
		List<User> listuser = userServiceImpl.getUserByName("%"+un+"%");
		request.getSession().setAttribute("listuser", listuser);
		return "admin/userlist";
	}
	
	
	/**
	 * 根据用户名删除
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String un = request.getParameter("username");
		un = new String(un.getBytes("ISO-8859-1"), "UTF-8");
		User user = new User();
		user.setUserName(un);
		int result = userServiceImpl.delete(user);
		if (result == 1) {
			request.setAttribute("success", "删除成功！");
			return "redirect:/adminUser/list";
		} else {
			request.setAttribute("error", "删除失败！");
			return "redirect:/adminUser/list";
		}
	}
	
	/**
	 * 删除都用户
	 * @return
	 */
	@RequestMapping("/mdel")
	public String mdel(HttpServletRequest request){
		String[] values = request.getParameterValues("chb");
		try {
			for (String un : values) {
				User user = new User();
				user.setUserName(un);
				userServiceImpl.delete(user);
			}
			request.setAttribute("success", "删除成功！");
			return "redirect:/adminUser/list";
		} catch (Exception e) {
			request.setAttribute("error", "删除失败！");
			return "redirect:/adminUser/list";
		}
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request){
		String un = request.getParameter("username");
		List<User> listuser = userServiceImpl.getUserByName(un);
		request.getSession().setAttribute("userInfo", listuser.get(0));
		return "admin/updateUser";
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/update")
	public String update(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String un = request.getParameter("un");
//		un = new String(un.getBytes("ISO-8859-1"), "UTF-8");
		String pwd = request.getParameter("password");
		String cellphone = request.getParameter("cellphone");
		User user = new User();
		user.setUserName(un);
		user.setPassWord(pwd);
		user.setCellphone(cellphone);
		int result = userServiceImpl.update(user);
		if (result == 1) {
			request.setAttribute("success", "修改密码成功！");
			return "redirect:/adminUser/list";
		} else {
			request.setAttribute("error", "修改密码失败！");
			return "redirect:/adminUser/list";
		}
	}
}

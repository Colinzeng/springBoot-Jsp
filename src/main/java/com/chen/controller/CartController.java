package com.chen.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.pojo.Cart;
import com.chen.service.CartServiceImpl;

@Controller
@RequestMapping("/cart")
public class CartController{
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		Cart cart = new Cart();
		String userName = (String) request.getSession().getAttribute("username");
		cart.setUserName(userName);
		List<Cart> list2 = cartServiceImpl.getAll(cart);
		double total = 0;
		for (Cart cart2 : list2) {
			total += cart2.getPrice() * cart2.getNum();
		}
		request.getSession().setAttribute("total", total);
		request.getSession().setAttribute("list2", list2);
		return "cart";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String userName = (String) request.getSession().getAttribute("username");
		String gid = request.getParameter("gid");
		String img = request.getParameter("img");
		String name = request.getParameter("name");
//		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String type = request.getParameter("color");
		String price = request.getParameter("price");
		String num = request.getParameter("num");
		Cart cart = new Cart();
		cart.setGid(gid);
		cart.setImg(img);
		cart.setName(name);
		cart.setType(type);
		cart.setUserName(userName);
		cart.setPrice(Double.parseDouble(price));
		if(num != null && userName != null){
			cart.setNum(Integer.parseInt(num));
		}else {
			request.setAttribute("error", "请登录后再添加购物车");
			return "redirect:/good/det?id="+gid;
		}
		List<Cart> list = cartServiceImpl.getCartByGid(cart);
		if (list == null || list.size() < 1) {
			int result1 = cartServiceImpl.insert(cart);
			if (result1 >= 1) {
				request.setAttribute("success", "添加购物车成功");
				return "redirect:/cart/list";
			}
		} else {
			for (Cart cart2 : list) {
				int num1 = cart2.getNum() + cart.getNum();
				cart.setNum(num1);
				int result = cartServiceImpl.update(cart);
				if (result >= 1) {
					request.setAttribute("success", "添加购物车成功");
					return "redirect:/cart/list";
				}
			}
		}
		return "redirect:/cart/list";
	}
	
	
	/**
	 * 根据用户名删除
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/del")
	public String del(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String userName = (String) request.getSession().getAttribute("username");
		String gid = request.getParameter("gid");
		String type = request.getParameter("type");
//		type = new String(type.getBytes("ISO-8859-1"), "UTF-8");
		Cart cart = new Cart();
		cart.setGid(gid);
		cart.setType(type);
		cart.setUserName(userName);
		int result = cartServiceImpl.delete(cart);
		if (result != 0) {
			request.setAttribute("success", "删除成功");
			return "redirect:/cart/list";
		} else {
			request.setAttribute("error", "删除失败");
			return "redirect:/cart/list";
		}
	}
}

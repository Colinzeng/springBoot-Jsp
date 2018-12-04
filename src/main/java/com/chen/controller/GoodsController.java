package com.chen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chen.pojo.Goods;
import com.chen.service.GoodsServiceImpl;

/**
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("/good")
public class GoodsController {
	
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	/**
	 * 根据id查询是商品详情
	 * @param request
	 * @return
	 */
	@RequestMapping("/det")
	public String det(HttpServletRequest request){
		String id=request.getParameter("id");
		Goods goods=new Goods();
		goods.setId(id);
		List<Goods> list=goodsServiceImpl.getGoodById(goods);
		request.getSession().setAttribute("list", list);
		return "detail";
	}
	
	/**
	 * 搜索
	 * @return
	 */
	@RequestMapping("/fuzzy")
	public String fuzzy(HttpServletRequest request){
		String goods=request.getParameter("goods");
		List<Goods> listgoods=goodsServiceImpl.getGoodByName(goods);
		request.getSession().setAttribute("listgoods", listgoods);
		return "search";
	}
	
}

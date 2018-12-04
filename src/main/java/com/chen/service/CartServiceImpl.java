package com.chen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.mapper.CartMapper;
import com.chen.pojo.Cart;

@Service
public class CartServiceImpl{
	
	@Autowired
	private CartMapper cartMapper;

	public int insert(Cart cart) {
		return cartMapper.insert(cart);
	}

	public int delete(Cart cart) {
		return cartMapper.delete(cart);
	}

	public int update(Cart cart) { 
		return cartMapper.update(cart);
	}

	public List<Cart> getAll(Cart cart) {
		return cartMapper.getAll(cart);
	}

	public List<Cart> getCartByGid(Cart cart) {
		return cartMapper.getCartByGid(cart);
	}



}

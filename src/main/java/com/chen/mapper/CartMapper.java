package com.chen.mapper;

import java.util.List;

import com.chen.pojo.Cart;

public interface CartMapper {
	
	public int insert(Cart cart);

	public int delete(Cart cart);

	public int update(Cart cart);

	public List<Cart> getAll(Cart cart);

	public List<Cart> getCartByGid(Cart cart);

}

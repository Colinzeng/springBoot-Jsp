package com.chen.pojo;

import java.io.Serializable;

/**
 * 
 * @author admin
 *
 */
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String gid;
	private String img;
	private String name;
	private String type;
	private Double price;
	private Integer num;
	private String userName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String id, String gid, String img, String name, String type,
			double price, int num) {
		super();
		this.id = id;
		this.gid = gid;
		this.img = img;
		this.name = name;
		this.type = type;
		this.price = price;
		this.num = num;
	}

}

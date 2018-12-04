package com.chen.pojo;

import java.io.Serializable;

/**
 * 
 * @author admin
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String passWord;
	private String cellphone;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}

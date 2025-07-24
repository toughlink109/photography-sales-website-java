package com.entity.vo;

import com.entity.OrdinaryUserEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 用户
 * @author 
 * @email 
 */
public class OrdinaryUserVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 姓名
	 */
	
	private String realName;
		
	/**
	 * 性别
	 */
	
	private String userSex;
		
	/**
	 * 手机
	 */
	
	private String mobile;
		
	/**
	 * 邮箱
	 */
	
	private String email;
		
	/**
	 * 身份证
	 */
	
	private String idCard;
		
	/**
	 * 头像
	 */
	
	private String userAvatar;
		
	/**
	 * 余额
	 */
	
	private Double money;
		
	/**
	 * 是否会员
	 */
	
	private String vip;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getRealName() {
		return realName;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	/**
	 * 获取：性别
	 */
	public String getUserSex() {
		return userSex;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取：手机
	 */
	public String getMobile() {
		return mobile;
	}
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
				
	
	/**
	 * 设置：身份证
	 */
	 
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	/**
	 * 获取：身份证
	 */
	public String getIdCard() {
		return idCard;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	
	/**
	 * 获取：头像
	 */
	public String getUserAvatar() {
		return userAvatar;
	}
				
	
	/**
	 * 设置：余额
	 */
	 
	public void setMoney(Double money) {
		this.money = money;
	}
	
	/**
	 * 获取：余额
	 */
	public Double getMoney() {
		return money;
	}
				
	
	/**
	 * 设置：是否会员
	 */
	 
	public void setVip(String vip) {
		this.vip = vip;
	}
	
	/**
	 * 获取：是否会员
	 */
	public String getVip() {
		return vip;
	}
			
}

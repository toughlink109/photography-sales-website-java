package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 用户
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("ordinaryUser")
public class OrdinaryUserEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public OrdinaryUserEntity() {
		
	}
	
	public OrdinaryUserEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId
    private Long id;
	/**
	 * 账号
	 */
					
	private String account;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addTime;

	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：账号
	 */
	public String getAccount() {
		return account;
	}
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

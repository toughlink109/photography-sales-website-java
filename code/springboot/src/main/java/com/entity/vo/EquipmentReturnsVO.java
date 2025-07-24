package com.entity.vo;

import com.entity.EquipmentReturnsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 设备归还
 * @author 
 * @email 
 */
public class EquipmentReturnsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 型号
	 */
	
	private String model;
		
	/**
	 * 品牌
	 */
	
	private String brand;
		
	/**
	 * 账号
	 */
	
	private String account;
		
	/**
	 * 姓名
	 */
	
	private String realName;
		
	/**
	 * 归还时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date returnTime;
				
	
	/**
	 * 设置：型号
	 */
	 
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * 获取：型号
	 */
	public String getModel() {
		return model;
	}
				
	
	/**
	 * 设置：品牌
	 */
	 
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
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
	 * 设置：归还时间
	 */
	 
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	
	/**
	 * 获取：归还时间
	 */
	public Date getReturnTime() {
		return returnTime;
	}
			
}

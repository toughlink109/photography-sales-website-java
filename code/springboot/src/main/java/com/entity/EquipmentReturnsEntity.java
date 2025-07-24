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
 * 设备归还
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("equipmentReturns")
public class EquipmentReturnsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public EquipmentReturnsEntity() {
		
	}
	
	public EquipmentReturnsEntity(T t) {
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
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 设备名称
	 */
					
	private String equipmentName;
	
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
	 * 设置：设备名称
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getEquipmentName() {
		return equipmentName;
	}
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

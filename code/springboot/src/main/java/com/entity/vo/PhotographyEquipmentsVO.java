package com.entity.vo;

import com.entity.PhotographyEquipmentsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 摄影设备
 * @author 
 * @email 
 */
public class PhotographyEquipmentsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 设备名称
	 */
	
	private String equipmentName;
		
	/**
	 * 图片
	 */
	
	private String image;
		
	/**
	 * 品牌
	 */
	
	private String brand;
		
	/**
	 * 型号
	 */
	
	private String model;
		
	/**
	 * 用途说明
	 */
	
	private String usageNote;
		
	/**
	 * 小时租金
	 */
	
	private Integer rentalHourlyRate;
		
	/**
	 * 数量
	 */
	
	private Integer quantity;
		
	/**
	 * 设备详情
	 */
	
	private String equipmentDetails;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date lastClickTime;
		
	/**
	 * 评论数
	 */
	
	private Integer commentCount;
		
	/**
	 * 收藏数
	 */
	
	private Integer favoriteCount;
				
	
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
	 * 设置：图片
	 */
	 
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * 获取：图片
	 */
	public String getImage() {
		return image;
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
	 * 设置：用途说明
	 */
	 
	public void setUsageNote(String usageNote) {
		this.usageNote = usageNote;
	}
	
	/**
	 * 获取：用途说明
	 */
	public String getUsageNote() {
		return usageNote;
	}
				
	
	/**
	 * 设置：小时租金
	 */
	 
	public void setRentalHourlyRate(Integer rentalHourlyRate) {
		this.rentalHourlyRate = rentalHourlyRate;
	}
	
	/**
	 * 获取：小时租金
	 */
	public Integer getRentalHourlyRate() {
		return rentalHourlyRate;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getQuantity() {
		return quantity;
	}
				
	
	/**
	 * 设置：设备详情
	 */
	 
	public void setEquipmentDetails(String equipmentDetails) {
		this.equipmentDetails = equipmentDetails;
	}
	
	/**
	 * 获取：设备详情
	 */
	public String getEquipmentDetails() {
		return equipmentDetails;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setLastClickTime(Date lastClickTime) {
		this.lastClickTime = lastClickTime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getLastClickTime() {
		return lastClickTime;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getCommentCount() {
		return commentCount;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
			
}

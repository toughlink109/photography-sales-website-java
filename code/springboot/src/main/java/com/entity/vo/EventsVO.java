package com.entity.vo;

import com.entity.EventsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 摄影活动
 * @author 
 * @email 
 */
public class EventsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动时间
	 */
	
	private String activityTime;
		
	/**
	 * 活动地点
	 */
	
	private String activityPlace;
		
	/**
	 * 活动目的
	 */
	
	private String eventLocation;
		
	/**
	 * 参与人群
	 */
	
	private String targetAudience;
		
	/**
	 * 活动内容
	 */
	
	private String eventContent;
		
	/**
	 * 器材要求
	 */
	
	private String equipmentRequire;
		
	/**
	 * 报名方式
	 */
	
	private String regisWay;
		
	/**
	 * 活动规则
	 */
	
	private String eventRules;
		
	/**
	 * 联系方式
	 */
	
	private String contactPhone;
		
	/**
	 * 注意事项
	 */
	
	private String notes;
		
	/**
	 * 封面
	 */
	
	private String coverImage;
				
	
	/**
	 * 设置：活动时间
	 */
	 
	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}
	
	/**
	 * 获取：活动时间
	 */
	public String getActivityTime() {
		return activityTime;
	}
				
	
	/**
	 * 设置：活动地点
	 */
	 
	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}
	
	/**
	 * 获取：活动地点
	 */
	public String getActivityPlace() {
		return activityPlace;
	}
				
	
	/**
	 * 设置：活动目的
	 */
	 
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	
	/**
	 * 获取：活动目的
	 */
	public String getEventLocation() {
		return eventLocation;
	}
				
	
	/**
	 * 设置：参与人群
	 */
	 
	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}
	
	/**
	 * 获取：参与人群
	 */
	public String getTargetAudience() {
		return targetAudience;
	}
				
	
	/**
	 * 设置：活动内容
	 */
	 
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	
	/**
	 * 获取：活动内容
	 */
	public String getEventContent() {
		return eventContent;
	}
				
	
	/**
	 * 设置：器材要求
	 */
	 
	public void setEquipmentRequire(String equipmentRequire) {
		this.equipmentRequire = equipmentRequire;
	}
	
	/**
	 * 获取：器材要求
	 */
	public String getEquipmentRequire() {
		return equipmentRequire;
	}
				
	
	/**
	 * 设置：报名方式
	 */
	 
	public void setRegisWay(String regisWay) {
		this.regisWay = regisWay;
	}
	
	/**
	 * 获取：报名方式
	 */
	public String getRegisWay() {
		return regisWay;
	}
				
	
	/**
	 * 设置：活动规则
	 */
	 
	public void setEventRules(String eventRules) {
		this.eventRules = eventRules;
	}
	
	/**
	 * 获取：活动规则
	 */
	public String getEventRules() {
		return eventRules;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getContactPhone() {
		return contactPhone;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getNotes() {
		return notes;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	/**
	 * 获取：封面
	 */
	public String getCoverImage() {
		return coverImage;
	}
			
}

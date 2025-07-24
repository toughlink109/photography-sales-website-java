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
 * 报名活动
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("activityRegistration")
public class ActivityRegistrationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ActivityRegistrationEntity() {
		
	}
	
	public ActivityRegistrationEntity(T t) {
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
	 * 活动名称
	 */
					
	private String activityName;
	
	/**
	 * 活动时间
	 */
					
	private String activityTime;
	
	/**
	 * 活动地点
	 */
					
	private String activityPlace;
	
	/**
	 * 封面
	 */
					
	private String coverImage;
	
	/**
	 * 账号
	 */
					
	private String account;
	
	/**
	 * 姓名
	 */
					
	private String realName;
	
	/**
	 * 报名时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date registrationTime;
	
	/**
	 * 是否审核
	 */
					
	private String isApproved;
	
	/**
	 * 审核回复
	 */
					
	private String approvedComments;
	
	
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
	 * 设置：活动名称
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	/**
	 * 获取：活动名称
	 */
	public String getActivityName() {
		return activityName;
	}
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
	 * 设置：报名时间
	 */
	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}
	/**
	 * 获取：报名时间
	 */
	public Date getRegistrationTime() {
		return registrationTime;
	}
	/**
	 * 设置：是否审核
	 */
	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}
	/**
	 * 获取：是否审核
	 */
	public String getIsApproved() {
		return isApproved;
	}
	/**
	 * 设置：审核回复
	 */
	public void setApprovedComments(String approvedComments) {
		this.approvedComments = approvedComments;
	}
	/**
	 * 获取：审核回复
	 */
	public String getApprovedComments() {
		return approvedComments;
	}

}

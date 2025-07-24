package com.entity.vo;

import com.entity.WorkPublishEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 作品发布
 * @author 
 * @email 
 */
public class WorkPublishVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 作品分类
	 */
	
	private String workCategory;
		
	/**
	 * 作品
	 */
	
	private String work;
		
	/**
	 * 作品描述
	 */
	
	private String workDescription;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date publishTime;
		
	/**
	 * 账号
	 */
	
	private String account;
		
	/**
	 * 姓名
	 */
	
	private String realName;
		
	/**
	 * 手机
	 */
	
	private String mobile;
		
	/**
	 * 是否审核
	 */
	
	private String isApproved;
		
	/**
	 * 审核回复
	 */
	
	private String approvedComments;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date lastClickTime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clickNum;
		
	/**
	 * 评论数
	 */
	
	private Integer commentCount;
		
	/**
	 * 收藏数
	 */
	
	private Integer favoriteCount;
				
	
	/**
	 * 设置：作品分类
	 */
	 
	public void setWorkCategory(String workCategory) {
		this.workCategory = workCategory;
	}
	
	/**
	 * 获取：作品分类
	 */
	public String getWorkCategory() {
		return workCategory;
	}
				
	
	/**
	 * 设置：作品
	 */
	 
	public void setWork(String work) {
		this.work = work;
	}
	
	/**
	 * 获取：作品
	 */
	public String getWork() {
		return work;
	}
				
	
	/**
	 * 设置：作品描述
	 */
	 
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	
	/**
	 * 获取：作品描述
	 */
	public String getWorkDescription() {
		return workDescription;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getPublishTime() {
		return publishTime;
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
	 * 设置：点击次数
	 */
	 
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClickNum() {
		return clickNum;
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

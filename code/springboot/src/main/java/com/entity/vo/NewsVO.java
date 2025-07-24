package com.entity.vo;

import com.entity.NewsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 新闻资讯
 * @author 
 * @email 
 */
public class NewsVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 简介
	 */
	
	private String introduction;
		
	/**
	 * 分类名称
	 */
	
	private String typeName;
		
	/**
	 * 发布人
	 */
	
	private String name;
		
	/**
	 * 头像
	 */
	
	private String headImage;
		
	/**
	 * 点击次数
	 */
	
	private Integer clickNum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date lastClickTime;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupNum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilyNum;
		
	/**
	 * 收藏数
	 */
	
	private Integer favoriteCount;
		
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 内容
	 */
	
	private String content;
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * 获取：简介
	 */
	public String getIntroduction() {
		return introduction;
	}
				
	
	/**
	 * 设置：分类名称
	 */
	 
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	/**
	 * 获取：分类名称
	 */
	public String getTypeName() {
		return typeName;
	}
				
	
	/**
	 * 设置：发布人
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：发布人
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	
	/**
	 * 获取：头像
	 */
	public String getHeadImage() {
		return headImage;
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
	 * 设置：赞
	 */
	 
	public void setThumbsupNum(Integer thumbsupNum) {
		this.thumbsupNum = thumbsupNum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupNum() {
		return thumbsupNum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilyNum(Integer crazilyNum) {
		this.crazilyNum = crazilyNum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilyNum() {
		return crazilyNum;
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
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
			
}

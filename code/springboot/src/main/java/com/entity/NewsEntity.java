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
 * 新闻资讯
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("news")
public class NewsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NewsEntity() {
		
	}
	
	public NewsEntity(T t) {
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
	 * 标题
	 */
					
	private String title;
	
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
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

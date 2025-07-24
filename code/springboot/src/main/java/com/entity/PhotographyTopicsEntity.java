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
 * 摄影话题
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("photographyTopics")
public class PhotographyTopicsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PhotographyTopicsEntity() {
		
	}
	
	public PhotographyTopicsEntity(T t) {
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
	 * 话题分类
	 */
					
	private String topicCategories;
	
	/**
	 * 封面
	 */
					
	private String coverImage;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date publishTime;
	
	/**
	 * 内容
	 */
					
	private String content;
	
	/**
	 * 账号
	 */
					
	private String account;
	
	/**
	 * 姓名
	 */
					
	private String realName;
	
	/**
	 * 是否审核
	 */
					
	private String isApproved;
	
	/**
	 * 审核回复
	 */
					
	private String approvedComments;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupNum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilyNum;
	
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
	 * 设置：话题分类
	 */
	public void setTopicCategories(String topicCategories) {
		this.topicCategories = topicCategories;
	}
	/**
	 * 获取：话题分类
	 */
	public String getTopicCategories() {
		return topicCategories;
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

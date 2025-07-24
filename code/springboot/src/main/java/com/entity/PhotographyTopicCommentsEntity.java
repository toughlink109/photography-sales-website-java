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
 * 摄影话题评论表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("photographyTopicComments")
public class PhotographyTopicCommentsEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PhotographyTopicCommentsEntity() {
		
	}
	
	public PhotographyTopicCommentsEntity(T t) {
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
	 * 关联表id
	 */
					
	private Long refId;
	
	/**
	 * 用户id
	 */
					
	private Long userId;
	
	/**
	 * 头像
	 */
					
	private String avatarUrl;
	
	/**
	 * 用户名
	 */
					
	private String nickname;
	
	/**
	 * 评论内容
	 */
					
	private String content;
	
	/**
	 * 回复内容
	 */
					
	private String reply;
	
	
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
	 * 设置：关联表id
	 */
	public void setRefId(Long refId) {
		this.refId = refId;
	}
	/**
	 * 获取：关联表id
	 */
	public Long getRefId() {
		return refId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}
	/**
	 * 设置：用户名
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：用户名
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：回复内容
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * 获取：回复内容
	 */
	public String getReply() {
		return reply;
	}

}

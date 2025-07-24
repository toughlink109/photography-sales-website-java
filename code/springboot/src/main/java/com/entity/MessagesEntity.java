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
 * 留言板
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("messages")
public class MessagesEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MessagesEntity() {
		
	}
	
	public MessagesEntity(T t) {
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
	 * 留言人id
	 */
					
	private Long userId;
	
	/**
	 * 用户名
	 */
					
	private String username;
	
	/**
	 * 头像
	 */
					
	private String avatarUrl;
	
	/**
	 * 留言内容
	 */
					
	private String content;
	
	/**
	 * 留言图片
	 */
					
	private String msgImage;
	
	/**
	 * 回复内容
	 */
					
	private String reply;
	
	/**
	 * 回复图片
	 */
					
	private String replyImage;
	
	
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
	 * 设置：留言人id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：留言人id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
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
	 * 设置：留言内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：留言内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：留言图片
	 */
	public void setMsgImage(String msgImage) {
		this.msgImage = msgImage;
	}
	/**
	 * 获取：留言图片
	 */
	public String getMsgImage() {
		return msgImage;
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
	/**
	 * 设置：回复图片
	 */
	public void setReplyImage(String replyImage) {
		this.replyImage = replyImage;
	}
	/**
	 * 获取：回复图片
	 */
	public String getReplyImage() {
		return replyImage;
	}

}

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
 * 作品投票
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("workVote")
public class WorkVoteEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WorkVoteEntity() {
		
	}
	
	public WorkVoteEntity(T t) {
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
	 * 作品名称
	 */
					
	private String workName;
	
	/**
	 * 作品分类
	 */
					
	private String workCategory;
	
	/**
	 * 账号
	 */
					
	private String account;
	
	/**
	 * 姓名
	 */
					
	private String realName;
	
	/**
	 * 投票票数
	 */
					
	private String voteCount;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossUserId;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossRefId;
	
	
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
	 * 设置：作品名称
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	/**
	 * 获取：作品名称
	 */
	public String getWorkName() {
		return workName;
	}
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
	 * 设置：投票票数
	 */
	public void setVoteCount(String voteCount) {
		this.voteCount = voteCount;
	}
	/**
	 * 获取：投票票数
	 */
	public String getVoteCount() {
		return voteCount;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossUserId(Long crossUserId) {
		this.crossUserId = crossUserId;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossUserId() {
		return crossUserId;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossRefId(Long crossRefId) {
		this.crossRefId = crossRefId;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossRefId() {
		return crossRefId;
	}

}

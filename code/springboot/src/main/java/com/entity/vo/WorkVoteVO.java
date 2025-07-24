package com.entity.vo;

import com.entity.WorkVoteEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 作品投票
 * @author 
 * @email 
 */
public class WorkVoteVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

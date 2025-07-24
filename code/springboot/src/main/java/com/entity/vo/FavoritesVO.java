package com.entity.vo;

import com.entity.FavoritesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 收藏表
 * @author 
 * @email 
 */
public class FavoritesVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品id
	 */
	
	private Long refId;
		
	/**
	 * 表名
	 */
	
	private String tableName;
		
	/**
	 * 名称
	 */
	
	private String name;
		
	/**
	 * 图片
	 */
	
	private String picture;
		
	/**
	 * 类型
	 */
	
	private String type;
		
	/**
	 * 推荐类型
	 */
	
	private String recommendType;
		
	/**
	 * 备注
	 */
	
	private String remark;
				
	
	/**
	 * 设置：商品id
	 */
	 
	public void setRefId(Long refId) {
		this.refId = refId;
	}
	
	/**
	 * 获取：商品id
	 */
	public Long getRefId() {
		return refId;
	}
				
	
	/**
	 * 设置：表名
	 */
	 
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * 获取：表名
	 */
	public String getTableName() {
		return tableName;
	}
				
	
	/**
	 * 设置：名称
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
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
	 * 设置：类型
	 */
	 
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
				
	
	/**
	 * 设置：推荐类型
	 */
	 
	public void setRecommendType(String recommendType) {
		this.recommendType = recommendType;
	}
	
	/**
	 * 获取：推荐类型
	 */
	public String getRecommendType() {
		return recommendType;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
			
}

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
 * 购物车表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 */
@TableName("cart")
public class CartEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CartEntity() {
		
	}
	
	public CartEntity(T t) {
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
	 * 商品表名
	 */
					
	private String tableName;
	
	/**
	 * 用户id
	 */
					
	private Long userId;
	
	/**
	 * 商品id
	 */
					
	private Long productId;
	
	/**
	 * 商品名称
	 */
					
	private String productTitle;
	
	/**
	 * 图片
	 */
					
	private String picture;
	
	/**
	 * 购买数量
	 */
					
	private Integer quantity;
	
	/**
	 * 单价
	 */
					
	private Double price;
	
	/**
	 * 会员价
	 */
					
	private Double discountPrice;
	
	
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
	 * 设置：商品表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取：商品表名
	 */
	public String getTableName() {
		return tableName;
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
	 * 设置：商品id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：商品id
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * 设置：商品名称
	 */
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	/**
	 * 获取：商品名称
	 */
	public String getProductTitle() {
		return productTitle;
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
	 * 设置：购买数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：购买数量
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：会员价
	 */
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	/**
	 * 获取：会员价
	 */
	public Double getDiscountPrice() {
		return discountPrice;
	}

}

package com.entity.vo;

import com.entity.CartEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 购物车表
 * @author 
 * @email 
 */
public class CartVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

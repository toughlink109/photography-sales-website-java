package com.entity.vo;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 订单
 * @author 
 * @email 
 */
public class OrdersVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 商品图片
	 */
	
	private String picture;
		
	/**
	 * 购买数量
	 */
	
	private Integer quantity;
		
	/**
	 * 价格
	 */
	
	private Double price;
		
	/**
	 * 总价格
	 */
	
	private Double total;
		
	/**
	 * 折扣价格
	 */
	
	private Double discountPrice;
		
	/**
	 * 折扣总价格
	 */
	
	private Double discountTotal;
		
	/**
	 * 支付类型
	 */
	
	private Integer type;
		
	/**
	 * 状态
	 */
	
	private String status;
		
	/**
	 * 地址
	 */
	
	private String address;
		
	/**
	 * 电话
	 */
	
	private String tel;
		
	/**
	 * 收货人
	 */
	
	private String consignee;
		
	/**
	 * 物流
	 */
	
	private String logistics;
		
	/**
	 * 备注
	 */
	
	private String remark;
		
	/**
	 * 是否审核
	 */
	
	private String isApproved;
		
	/**
	 * 审核回复
	 */
	
	private String approvedComments;
		
	/**
	 * 用户角色
	 */
	
	private String role;
				
	
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
	 * 设置：商品图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：商品图片
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
	 * 设置：价格
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：总价格
	 */
	 
	public void setTotal(Double total) {
		this.total = total;
	}
	
	/**
	 * 获取：总价格
	 */
	public Double getTotal() {
		return total;
	}
				
	
	/**
	 * 设置：折扣价格
	 */
	 
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	/**
	 * 获取：折扣价格
	 */
	public Double getDiscountPrice() {
		return discountPrice;
	}
				
	
	/**
	 * 设置：折扣总价格
	 */
	 
	public void setDiscountTotal(Double discountTotal) {
		this.discountTotal = discountTotal;
	}
	
	/**
	 * 获取：折扣总价格
	 */
	public Double getDiscountTotal() {
		return discountTotal;
	}
				
	
	/**
	 * 设置：支付类型
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：支付类型
	 */
	public Integer getType() {
		return type;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
				
	
	/**
	 * 设置：电话
	 */
	 
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
				
	
	/**
	 * 设置：收货人
	 */
	 
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * 获取：收货人
	 */
	public String getConsignee() {
		return consignee;
	}
				
	
	/**
	 * 设置：物流
	 */
	 
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	
	/**
	 * 获取：物流
	 */
	public String getLogistics() {
		return logistics;
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
	 * 设置：用户角色
	 */
	 
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * 获取：用户角色
	 */
	public String getRole() {
		return role;
	}
			
}

package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 摄影设备租用
 * 数据库通用操作实体类（普通增删改查）
 * @author
 * @email
 */
@TableName("equipmentRental")
public class EquipmentRentalEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public EquipmentRentalEntity() {

	}

	public EquipmentRentalEntity(T t) {
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
	 * 设备编号
	 */

	private String equipmentId;

	/**
	 * 设备名称
	 */

	private String equipmentName;

	/**
	 * 型号
	 */

	private String model;

	/**
	 * 品牌
	 */

	private String brand;

	/**
	 * 用途说明
	 */

	private String usageNote;

	/**
	 * 小时租金
	 */

	private Double rentalHourlyRate;

	/**
	 * 数量
	 */

	private Integer quantity;

	/**
	 * 租用时长
	 */

	private Integer rentalDuration;

	/**
	 * 总金额
	 */

	private Double amount;

	/**
	 * 账号
	 */

	private String account;

	/**
	 * 姓名
	 */

	private String realName;

	/**
	 * 下单时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date orderTime;

	/**
	 * 是否审核
	 */

	private String isApproved;

	/**
	 * 审核回复
	 */

	private String approvedComments;

	/**
	 * 是否支付
	 */

	private String payStatus;


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
	 * 设置：设备编号
	 */
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	/**
	 * 获取：设备编号
	 */
	public String getEquipmentId() {
		return equipmentId;
	}
	/**
	 * 设置：设备名称
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getEquipmentName() {
		return equipmentName;
	}
	/**
	 * 设置：型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：用途说明
	 */
	public void setUsageNote(String usageNote) {
		this.usageNote = usageNote;
	}
	/**
	 * 获取：用途说明
	 */
	public String getUsageNote() {
		return usageNote;
	}
	/**
	 * 设置：小时租金
	 */
	public void setRentalHourlyRate(Double rentalHourlyRate) {
		this.rentalHourlyRate = rentalHourlyRate;
	}
	/**
	 * 获取：小时租金
	 */
	public Double getRentalHourlyRate() {
		return rentalHourlyRate;
	}
	/**
	 * 设置：数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：数量
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * 设置：租用时长
	 */
	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	/**
	 * 获取：租用时长
	 */
	public Integer getRentalDuration() {
		return rentalDuration;
	}
	/**
	 * 设置：总金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * 获取：总金额
	 */
	public Double getAmount() {
		return amount;
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
	 * 设置：下单时间
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * 获取：下单时间
	 */
	public Date getOrderTime() {
		return orderTime;
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
	 * 设置：是否支付
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：是否支付
	 */
	public String getPayStatus() {
		return payStatus;
	}

}

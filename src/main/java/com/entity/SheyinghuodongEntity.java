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
 * 摄影活动
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@TableName("sheyinghuodong")
public class SheyinghuodongEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SheyinghuodongEntity() {
		
	}
	
	public SheyinghuodongEntity(T t) {
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
	 * 活动名称
	 */
					
	private String huodongmingcheng;
	
	/**
	 * 活动时间
	 */
					
	private String huodongshijian;
	
	/**
	 * 活动地点
	 */
					
	private String huodongdidian;
	
	/**
	 * 活动目的
	 */
					
	private String huodongmude;
	
	/**
	 * 参与人群
	 */
					
	private String canyurenqun;
	
	/**
	 * 活动内容
	 */
					
	private String huodongneirong;
	
	/**
	 * 器材要求
	 */
					
	private String qicaiyaoqiu;
	
	/**
	 * 报名方式
	 */
					
	private String baomingfangshi;
	
	/**
	 * 活动规则
	 */
					
	private String huodongguize;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：活动名称
	 */
	public void setHuodongmingcheng(String huodongmingcheng) {
		this.huodongmingcheng = huodongmingcheng;
	}
	/**
	 * 获取：活动名称
	 */
	public String getHuodongmingcheng() {
		return huodongmingcheng;
	}
	/**
	 * 设置：活动时间
	 */
	public void setHuodongshijian(String huodongshijian) {
		this.huodongshijian = huodongshijian;
	}
	/**
	 * 获取：活动时间
	 */
	public String getHuodongshijian() {
		return huodongshijian;
	}
	/**
	 * 设置：活动地点
	 */
	public void setHuodongdidian(String huodongdidian) {
		this.huodongdidian = huodongdidian;
	}
	/**
	 * 获取：活动地点
	 */
	public String getHuodongdidian() {
		return huodongdidian;
	}
	/**
	 * 设置：活动目的
	 */
	public void setHuodongmude(String huodongmude) {
		this.huodongmude = huodongmude;
	}
	/**
	 * 获取：活动目的
	 */
	public String getHuodongmude() {
		return huodongmude;
	}
	/**
	 * 设置：参与人群
	 */
	public void setCanyurenqun(String canyurenqun) {
		this.canyurenqun = canyurenqun;
	}
	/**
	 * 获取：参与人群
	 */
	public String getCanyurenqun() {
		return canyurenqun;
	}
	/**
	 * 设置：活动内容
	 */
	public void setHuodongneirong(String huodongneirong) {
		this.huodongneirong = huodongneirong;
	}
	/**
	 * 获取：活动内容
	 */
	public String getHuodongneirong() {
		return huodongneirong;
	}
	/**
	 * 设置：器材要求
	 */
	public void setQicaiyaoqiu(String qicaiyaoqiu) {
		this.qicaiyaoqiu = qicaiyaoqiu;
	}
	/**
	 * 获取：器材要求
	 */
	public String getQicaiyaoqiu() {
		return qicaiyaoqiu;
	}
	/**
	 * 设置：报名方式
	 */
	public void setBaomingfangshi(String baomingfangshi) {
		this.baomingfangshi = baomingfangshi;
	}
	/**
	 * 获取：报名方式
	 */
	public String getBaomingfangshi() {
		return baomingfangshi;
	}
	/**
	 * 设置：活动规则
	 */
	public void setHuodongguize(String huodongguize) {
		this.huodongguize = huodongguize;
	}
	/**
	 * 获取：活动规则
	 */
	public String getHuodongguize() {
		return huodongguize;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}

}

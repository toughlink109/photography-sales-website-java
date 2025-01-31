package com.entity.model;

import com.entity.SheyinghuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 摄影活动
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public class SheyinghuodongModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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

package com.entity.vo;

import com.entity.PhotographyWorksEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 摄影作品
 * @author 
 * @email 
 */
public class PhotographyWorksVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 作品分类
	 */
	
	private String workCategory;
		
	/**
	 * 封面
	 */
	
	private String coverImage;
		
	/**
	 * 拍摄时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shotTime;
		
	/**
	 * 拍摄地点
	 */
	
	private String shotLocation;
		
	/**
	 * 发布日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date publishDate;
		
	/**
	 * 作品内容
	 */
	
	private String workContent;
		
	/**
	 * 单限
	 */
	
	private Integer limitOne;
		
	/**
	 * 库存
	 */
	
	private Integer goodsStocks;
		
	/**
	 * 投票票数
	 */
	
	private Integer voteCount;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupNum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilyNum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date lastClickTime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clickNum;
		
	/**
	 * 评论数
	 */
	
	private Integer commentCount;
		
	/**
	 * 价格
	 */
	
	private Double price;
		
	/**
	 * 会员价
	 */
	
	private Double vipPrice;
		
	/**
	 * 收藏数
	 */
	
	private Integer favoriteCount;
				
	
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
	 * 设置：封面
	 */
	 
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	/**
	 * 获取：封面
	 */
	public String getCoverImage() {
		return coverImage;
	}
				
	
	/**
	 * 设置：拍摄时间
	 */
	 
	public void setShotTime(Date shotTime) {
		this.shotTime = shotTime;
	}
	
	/**
	 * 获取：拍摄时间
	 */
	public Date getShotTime() {
		return shotTime;
	}
				
	
	/**
	 * 设置：拍摄地点
	 */
	 
	public void setShotLocation(String shotLocation) {
		this.shotLocation = shotLocation;
	}
	
	/**
	 * 获取：拍摄地点
	 */
	public String getShotLocation() {
		return shotLocation;
	}
				
	
	/**
	 * 设置：发布日期
	 */
	 
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	/**
	 * 获取：发布日期
	 */
	public Date getPublishDate() {
		return publishDate;
	}
				
	
	/**
	 * 设置：作品内容
	 */
	 
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	
	/**
	 * 获取：作品内容
	 */
	public String getWorkContent() {
		return workContent;
	}
				
	
	/**
	 * 设置：单限
	 */
	 
	public void setLimitOne(Integer limitOne) {
		this.limitOne = limitOne;
	}
	
	/**
	 * 获取：单限
	 */
	public Integer getLimitOne() {
		return limitOne;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setGoodsStocks(Integer goodsStocks) {
		this.goodsStocks = goodsStocks;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getGoodsStocks() {
		return goodsStocks;
	}
				
	
	/**
	 * 设置：投票票数
	 */
	 
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	
	/**
	 * 获取：投票票数
	 */
	public Integer getVoteCount() {
		return voteCount;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupNum(Integer thumbsupNum) {
		this.thumbsupNum = thumbsupNum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupNum() {
		return thumbsupNum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilyNum(Integer crazilyNum) {
		this.crazilyNum = crazilyNum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilyNum() {
		return crazilyNum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setLastClickTime(Date lastClickTime) {
		this.lastClickTime = lastClickTime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getLastClickTime() {
		return lastClickTime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClickNum() {
		return clickNum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getCommentCount() {
		return commentCount;
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
	 * 设置：会员价
	 */
	 
	public void setVipPrice(Double vipPrice) {
		this.vipPrice = vipPrice;
	}
	
	/**
	 * 获取：会员价
	 */
	public Double getVipPrice() {
		return vipPrice;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
			
}

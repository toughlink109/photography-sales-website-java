package com.entity.view;

import com.entity.DiscusssheyingshebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影设备评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
@TableName("discusssheyingshebei")
public class DiscusssheyingshebeiView  extends DiscusssheyingshebeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusssheyingshebeiView(){
	}
 
 	public DiscusssheyingshebeiView(DiscusssheyingshebeiEntity discusssheyingshebeiEntity){
 	try {
			BeanUtils.copyProperties(this, discusssheyingshebeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

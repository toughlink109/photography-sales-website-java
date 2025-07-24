package com.entity.view;

import com.entity.TopicCategoriesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 话题分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("topicCategories")
public class TopicCategoriesView  extends TopicCategoriesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TopicCategoriesView(){
	}
 
 	public TopicCategoriesView(TopicCategoriesEntity topicCategoriesEntity){
 	try {
			BeanUtils.copyProperties(this, topicCategoriesEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

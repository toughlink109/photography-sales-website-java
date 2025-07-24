package com.entity.view;

import com.entity.WorkCommentsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 作品发布评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("workComments")
public class WorkCommentsView  extends WorkCommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WorkCommentsView(){
	}
 
 	public WorkCommentsView(WorkCommentsEntity workCommentsEntity){
 	try {
			BeanUtils.copyProperties(this, workCommentsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

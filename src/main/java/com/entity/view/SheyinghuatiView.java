package com.entity.view;

import com.entity.SheyinghuatiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影话题
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@TableName("sheyinghuati")
public class SheyinghuatiView  extends SheyinghuatiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SheyinghuatiView(){
	}
 
 	public SheyinghuatiView(SheyinghuatiEntity sheyinghuatiEntity){
 	try {
			BeanUtils.copyProperties(this, sheyinghuatiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

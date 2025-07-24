package com.entity.view;

import com.entity.SystemIntroEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 系统简介
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("systemIntro")
public class SystemIntroView  extends SystemIntroEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SystemIntroView(){
	}
 
 	public SystemIntroView(SystemIntroEntity systemIntroEntity){
 	try {
			BeanUtils.copyProperties(this, systemIntroEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

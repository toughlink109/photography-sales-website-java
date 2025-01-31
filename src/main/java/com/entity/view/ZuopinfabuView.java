package com.entity.view;

import com.entity.ZuopinfabuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 作品发布
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@TableName("zuopinfabu")
public class ZuopinfabuView  extends ZuopinfabuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuopinfabuView(){
	}
 
 	public ZuopinfabuView(ZuopinfabuEntity zuopinfabuEntity){
 	try {
			BeanUtils.copyProperties(this, zuopinfabuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

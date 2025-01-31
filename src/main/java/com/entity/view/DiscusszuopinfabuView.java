package com.entity.view;

import com.entity.DiscusszuopinfabuEntity;

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
 * @date 2030-04-26 20:41:39
 */
@TableName("discusszuopinfabu")
public class DiscusszuopinfabuView  extends DiscusszuopinfabuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszuopinfabuView(){
	}
 
 	public DiscusszuopinfabuView(DiscusszuopinfabuEntity discusszuopinfabuEntity){
 	try {
			BeanUtils.copyProperties(this, discusszuopinfabuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

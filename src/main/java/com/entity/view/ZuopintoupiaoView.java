package com.entity.view;

import com.entity.ZuopintoupiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 作品投票
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
@TableName("zuopintoupiao")
public class ZuopintoupiaoView  extends ZuopintoupiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuopintoupiaoView(){
	}
 
 	public ZuopintoupiaoView(ZuopintoupiaoEntity zuopintoupiaoEntity){
 	try {
			BeanUtils.copyProperties(this, zuopintoupiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

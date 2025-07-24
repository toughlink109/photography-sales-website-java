package com.entity.view;

import com.entity.FavoritesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 收藏表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("favorites")
public class FavoritesView  extends FavoritesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FavoritesView(){
	}
 
 	public FavoritesView(FavoritesEntity favoritesEntity){
 	try {
			BeanUtils.copyProperties(this, favoritesEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

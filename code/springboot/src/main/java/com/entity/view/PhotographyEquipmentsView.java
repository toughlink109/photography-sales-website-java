package com.entity.view;

import com.entity.PhotographyEquipmentsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影设备
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("photographyEquipments")
public class PhotographyEquipmentsView  extends PhotographyEquipmentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PhotographyEquipmentsView(){
	}
 
 	public PhotographyEquipmentsView(PhotographyEquipmentsEntity photographyEquipmentsEntity){
 	try {
			BeanUtils.copyProperties(this, photographyEquipmentsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

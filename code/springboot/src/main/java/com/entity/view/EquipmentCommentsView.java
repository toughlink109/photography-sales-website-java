package com.entity.view;

import com.entity.EquipmentCommentsEntity;

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
 */
@TableName("equipmentComments")
public class EquipmentCommentsView  extends EquipmentCommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public EquipmentCommentsView(){
	}
 
 	public EquipmentCommentsView(EquipmentCommentsEntity equipmentCommentsEntity){
 	try {
			BeanUtils.copyProperties(this, equipmentCommentsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

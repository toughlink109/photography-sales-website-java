package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.EquipmentRentalEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 摄影设备租用
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("equipmentRental")
public class EquipmentRentalView  extends EquipmentRentalEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public EquipmentRentalView(){
	}
 
 	public EquipmentRentalView(EquipmentRentalEntity EquipmentRentalEntity){
 	try {
			BeanUtils.copyProperties(this, EquipmentRentalEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

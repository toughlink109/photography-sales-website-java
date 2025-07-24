package com.entity.view;

import com.entity.EventsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("events")
public class EventsView  extends EventsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public EventsView(){
	}
 
 	public EventsView(EventsEntity eventsEntity){
 	try {
			BeanUtils.copyProperties(this, eventsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

package com.entity.view;

import com.entity.WorkPublishEntity;

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
 */
@TableName("workPublish")
public class WorkPublishView  extends WorkPublishEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WorkPublishView(){
	}
 
 	public WorkPublishView(WorkPublishEntity workPublishEntity){
 	try {
			BeanUtils.copyProperties(this, workPublishEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

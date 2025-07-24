package com.entity.view;

import com.entity.PhotographyWorksEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影作品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("photographyWorks")
public class PhotographyWorksView  extends PhotographyWorksEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PhotographyWorksView(){
	}
 
 	public PhotographyWorksView(PhotographyWorksEntity photographyWorksEntity){
 	try {
			BeanUtils.copyProperties(this, photographyWorksEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

package com.entity.view;

import com.entity.DiscussWorkCommentsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 摄影作品评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 */
@TableName("discussWorkComments")
public class DiscussWorkCommentsView  extends DiscussWorkCommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussWorkCommentsView(){
	}
 
 	public DiscussWorkCommentsView(DiscussWorkCommentsEntity discussWorkCommentsEntity){
 	try {
			BeanUtils.copyProperties(this, discussWorkCommentsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

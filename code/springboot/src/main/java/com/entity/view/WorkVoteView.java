package com.entity.view;

import com.entity.WorkVoteEntity;

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
 */
@TableName("workVote")
public class WorkVoteView  extends WorkVoteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WorkVoteView(){
	}
 
 	public WorkVoteView(WorkVoteEntity workVoteEntity){
 	try {
			BeanUtils.copyProperties(this, workVoteEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

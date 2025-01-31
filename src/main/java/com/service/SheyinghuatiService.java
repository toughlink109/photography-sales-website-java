package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheyinghuatiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheyinghuatiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheyinghuatiView;


/**
 * 摄影话题
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyinghuatiService extends IService<SheyinghuatiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheyinghuatiVO> selectListVO(Wrapper<SheyinghuatiEntity> wrapper);
   	
   	SheyinghuatiVO selectVO(@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);
   	
   	List<SheyinghuatiView> selectListView(Wrapper<SheyinghuatiEntity> wrapper);
   	
   	SheyinghuatiView selectView(@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheyinghuatiEntity> wrapper);

   	

}


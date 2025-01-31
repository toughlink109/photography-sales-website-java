package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheyinghuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheyinghuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheyinghuodongView;


/**
 * 摄影活动
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyinghuodongService extends IService<SheyinghuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheyinghuodongVO> selectListVO(Wrapper<SheyinghuodongEntity> wrapper);
   	
   	SheyinghuodongVO selectVO(@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);
   	
   	List<SheyinghuodongView> selectListView(Wrapper<SheyinghuodongEntity> wrapper);
   	
   	SheyinghuodongView selectView(@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheyinghuodongEntity> wrapper);

   	

}


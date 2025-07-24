package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PhotographyTopicsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PhotographyTopicsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PhotographyTopicsView;


/**
 * 摄影话题
 *
 * @author 
 * @email 
 */
public interface PhotographyTopicsService extends IService<PhotographyTopicsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PhotographyTopicsVO> selectListVO(Wrapper<PhotographyTopicsEntity> wrapper);
   	
   	PhotographyTopicsVO selectVO(@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);
   	
   	List<PhotographyTopicsView> selectListView(Wrapper<PhotographyTopicsEntity> wrapper);
   	
   	PhotographyTopicsView selectView(@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PhotographyTopicsEntity> wrapper);

   	

}


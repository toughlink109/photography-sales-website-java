package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WorkCommentsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WorkCommentsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WorkCommentsView;


/**
 * 作品发布评论表
 *
 * @author 
 * @email 
 */
public interface WorkCommentsService extends IService<WorkCommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WorkCommentsVO> selectListVO(Wrapper<WorkCommentsEntity> wrapper);
   	
   	WorkCommentsVO selectVO(@Param("ew") Wrapper<WorkCommentsEntity> wrapper);
   	
   	List<WorkCommentsView> selectListView(Wrapper<WorkCommentsEntity> wrapper);
   	
   	WorkCommentsView selectView(@Param("ew") Wrapper<WorkCommentsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WorkCommentsEntity> wrapper);

   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EventsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EventsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EventsView;


/**
 * 摄影活动
 *
 * @author 
 * @email 
 */
public interface EventsService extends IService<EventsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EventsVO> selectListVO(Wrapper<EventsEntity> wrapper);
   	
   	EventsVO selectVO(@Param("ew") Wrapper<EventsEntity> wrapper);
   	
   	List<EventsView> selectListView(Wrapper<EventsEntity> wrapper);
   	
   	EventsView selectView(@Param("ew") Wrapper<EventsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EventsEntity> wrapper);

   	

}


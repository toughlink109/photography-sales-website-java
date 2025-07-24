package com.dao;

import com.entity.EventsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EventsVO;
import com.entity.view.EventsView;


/**
 * 摄影活动
 * 
 * @author 
 * @email 
 */
public interface EventsDao extends BaseMapper<EventsEntity> {
	
	List<EventsVO> selectListVO(@Param("ew") Wrapper<EventsEntity> wrapper);
	
	EventsVO selectVO(@Param("ew") Wrapper<EventsEntity> wrapper);
	
	List<EventsView> selectListView(@Param("ew") Wrapper<EventsEntity> wrapper);

	List<EventsView> selectListView(Pagination page,@Param("ew") Wrapper<EventsEntity> wrapper);

	
	EventsView selectView(@Param("ew") Wrapper<EventsEntity> wrapper);
	

}

package com.dao;

import com.entity.WorkPublishEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WorkPublishVO;
import com.entity.view.WorkPublishView;


/**
 * 作品发布
 * 
 * @author 
 * @email 
 */
public interface WorkPublishDao extends BaseMapper<WorkPublishEntity> {
	
	List<WorkPublishVO> selectListVO(@Param("ew") Wrapper<WorkPublishEntity> wrapper);
	
	WorkPublishVO selectVO(@Param("ew") Wrapper<WorkPublishEntity> wrapper);
	
	List<WorkPublishView> selectListView(@Param("ew") Wrapper<WorkPublishEntity> wrapper);

	List<WorkPublishView> selectListView(Pagination page,@Param("ew") Wrapper<WorkPublishEntity> wrapper);

	
	WorkPublishView selectView(@Param("ew") Wrapper<WorkPublishEntity> wrapper);
	

}

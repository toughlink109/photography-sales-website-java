package com.dao;

import com.entity.WorkCommentsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WorkCommentsVO;
import com.entity.view.WorkCommentsView;


/**
 * 作品发布评论表
 * 
 * @author 
 * @email 
 */
public interface WorkCommentsDao extends BaseMapper<WorkCommentsEntity> {
	
	List<WorkCommentsVO> selectListVO(@Param("ew") Wrapper<WorkCommentsEntity> wrapper);
	
	WorkCommentsVO selectVO(@Param("ew") Wrapper<WorkCommentsEntity> wrapper);
	
	List<WorkCommentsView> selectListView(@Param("ew") Wrapper<WorkCommentsEntity> wrapper);

	List<WorkCommentsView> selectListView(Pagination page,@Param("ew") Wrapper<WorkCommentsEntity> wrapper);

	
	WorkCommentsView selectView(@Param("ew") Wrapper<WorkCommentsEntity> wrapper);
	

}

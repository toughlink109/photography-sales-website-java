package com.dao;

import com.entity.PhotographyTopicsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PhotographyTopicsVO;
import com.entity.view.PhotographyTopicsView;


/**
 * 摄影话题
 * 
 * @author 
 * @email 
 */
public interface PhotographyTopicsDao extends BaseMapper<PhotographyTopicsEntity> {
	
	List<PhotographyTopicsVO> selectListVO(@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);
	
	PhotographyTopicsVO selectVO(@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);
	
	List<PhotographyTopicsView> selectListView(@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);

	List<PhotographyTopicsView> selectListView(Pagination page,@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);

	
	PhotographyTopicsView selectView(@Param("ew") Wrapper<PhotographyTopicsEntity> wrapper);
	

}

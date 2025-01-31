package com.dao;

import com.entity.SheyinghuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheyinghuodongVO;
import com.entity.view.SheyinghuodongView;


/**
 * 摄影活动
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyinghuodongDao extends BaseMapper<SheyinghuodongEntity> {
	
	List<SheyinghuodongVO> selectListVO(@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);
	
	SheyinghuodongVO selectVO(@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);
	
	List<SheyinghuodongView> selectListView(@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);

	List<SheyinghuodongView> selectListView(Pagination page,@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);

	
	SheyinghuodongView selectView(@Param("ew") Wrapper<SheyinghuodongEntity> wrapper);
	

}

package com.dao;

import com.entity.SheyingzuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheyingzuopinVO;
import com.entity.view.SheyingzuopinView;


/**
 * 摄影作品
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyingzuopinDao extends BaseMapper<SheyingzuopinEntity> {
	
	List<SheyingzuopinVO> selectListVO(@Param("ew") Wrapper<SheyingzuopinEntity> wrapper);
	
	SheyingzuopinVO selectVO(@Param("ew") Wrapper<SheyingzuopinEntity> wrapper);
	
	List<SheyingzuopinView> selectListView(@Param("ew") Wrapper<SheyingzuopinEntity> wrapper);

	List<SheyingzuopinView> selectListView(Pagination page,@Param("ew") Wrapper<SheyingzuopinEntity> wrapper);

	
	SheyingzuopinView selectView(@Param("ew") Wrapper<SheyingzuopinEntity> wrapper);
	

}

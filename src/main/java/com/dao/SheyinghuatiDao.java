package com.dao;

import com.entity.SheyinghuatiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheyinghuatiVO;
import com.entity.view.SheyinghuatiView;


/**
 * 摄影话题
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyinghuatiDao extends BaseMapper<SheyinghuatiEntity> {
	
	List<SheyinghuatiVO> selectListVO(@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);
	
	SheyinghuatiVO selectVO(@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);
	
	List<SheyinghuatiView> selectListView(@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);

	List<SheyinghuatiView> selectListView(Pagination page,@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);

	
	SheyinghuatiView selectView(@Param("ew") Wrapper<SheyinghuatiEntity> wrapper);
	

}

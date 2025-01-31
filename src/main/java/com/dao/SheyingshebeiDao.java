package com.dao;

import com.entity.SheyingshebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheyingshebeiVO;
import com.entity.view.SheyingshebeiView;


/**
 * 摄影设备
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyingshebeiDao extends BaseMapper<SheyingshebeiEntity> {
	
	List<SheyingshebeiVO> selectListVO(@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);
	
	SheyingshebeiVO selectVO(@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);
	
	List<SheyingshebeiView> selectListView(@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);

	List<SheyingshebeiView> selectListView(Pagination page,@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);

	
	SheyingshebeiView selectView(@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);
	

}

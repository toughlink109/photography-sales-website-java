package com.dao;

import com.entity.DiscusssheyingshebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssheyingshebeiVO;
import com.entity.view.DiscusssheyingshebeiView;


/**
 * 摄影设备评论表
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
public interface DiscusssheyingshebeiDao extends BaseMapper<DiscusssheyingshebeiEntity> {
	
	List<DiscusssheyingshebeiVO> selectListVO(@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);
	
	DiscusssheyingshebeiVO selectVO(@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);
	
	List<DiscusssheyingshebeiView> selectListView(@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);

	List<DiscusssheyingshebeiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);

	
	DiscusssheyingshebeiView selectView(@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);
	

}

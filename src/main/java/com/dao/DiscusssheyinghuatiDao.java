package com.dao;

import com.entity.DiscusssheyinghuatiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssheyinghuatiVO;
import com.entity.view.DiscusssheyinghuatiView;


/**
 * 摄影话题评论表
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:39
 */
public interface DiscusssheyinghuatiDao extends BaseMapper<DiscusssheyinghuatiEntity> {
	
	List<DiscusssheyinghuatiVO> selectListVO(@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);
	
	DiscusssheyinghuatiVO selectVO(@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);
	
	List<DiscusssheyinghuatiView> selectListView(@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);

	List<DiscusssheyinghuatiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);

	
	DiscusssheyinghuatiView selectView(@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);
	

}

package com.dao;

import com.entity.TopicCategoriesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TopicCategoriesVO;
import com.entity.view.TopicCategoriesView;


/**
 * 话题分类
 * 
 * @author 
 * @email 
 */
public interface TopicCategoriesDao extends BaseMapper<TopicCategoriesEntity> {
	
	List<TopicCategoriesVO> selectListVO(@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);
	
	TopicCategoriesVO selectVO(@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);
	
	List<TopicCategoriesView> selectListView(@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);

	List<TopicCategoriesView> selectListView(Pagination page,@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);

	
	TopicCategoriesView selectView(@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);
	

}

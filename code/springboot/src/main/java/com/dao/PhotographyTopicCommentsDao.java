package com.dao;

import com.entity.PhotographyTopicCommentsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PhotographyTopicCommentsVO;
import com.entity.view.PhotographyTopicCommentsView;


/**
 * 摄影话题评论表
 * 
 * @author 
 * @email 
 */
public interface PhotographyTopicCommentsDao extends BaseMapper<PhotographyTopicCommentsEntity> {
	
	List<PhotographyTopicCommentsVO> selectListVO(@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);
	
	PhotographyTopicCommentsVO selectVO(@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);
	
	List<PhotographyTopicCommentsView> selectListView(@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);

	List<PhotographyTopicCommentsView> selectListView(Pagination page,@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);

	
	PhotographyTopicCommentsView selectView(@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);
	

}

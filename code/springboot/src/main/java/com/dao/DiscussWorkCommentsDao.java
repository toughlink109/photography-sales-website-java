package com.dao;

import com.entity.DiscussWorkCommentsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussWorkCommentsVO;
import com.entity.view.DiscussWorkCommentsView;


/**
 * 摄影作品评论表
 * 
 * @author 
 * @email 
 */
public interface DiscussWorkCommentsDao extends BaseMapper<DiscussWorkCommentsEntity> {
	
	List<DiscussWorkCommentsVO> selectListVO(@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);
	
	DiscussWorkCommentsVO selectVO(@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);
	
	List<DiscussWorkCommentsView> selectListView(@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);

	List<DiscussWorkCommentsView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);

	
	DiscussWorkCommentsView selectView(@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);
	

}

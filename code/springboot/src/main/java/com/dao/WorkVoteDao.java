package com.dao;

import com.entity.WorkVoteEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WorkVoteVO;
import com.entity.view.WorkVoteView;


/**
 * 作品投票
 * 
 * @author 
 * @email 
 */
public interface WorkVoteDao extends BaseMapper<WorkVoteEntity> {
	
	List<WorkVoteVO> selectListVO(@Param("ew") Wrapper<WorkVoteEntity> wrapper);
	
	WorkVoteVO selectVO(@Param("ew") Wrapper<WorkVoteEntity> wrapper);
	
	List<WorkVoteView> selectListView(@Param("ew") Wrapper<WorkVoteEntity> wrapper);

	List<WorkVoteView> selectListView(Pagination page,@Param("ew") Wrapper<WorkVoteEntity> wrapper);

	
	WorkVoteView selectView(@Param("ew") Wrapper<WorkVoteEntity> wrapper);
	

}

package com.dao;

import com.entity.SystemIntroEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SystemIntroVO;
import com.entity.view.SystemIntroView;


/**
 * 系统简介
 * 
 * @author 
 * @email 
 */
public interface SystemIntroDao extends BaseMapper<SystemIntroEntity> {
	
	List<SystemIntroVO> selectListVO(@Param("ew") Wrapper<SystemIntroEntity> wrapper);
	
	SystemIntroVO selectVO(@Param("ew") Wrapper<SystemIntroEntity> wrapper);
	
	List<SystemIntroView> selectListView(@Param("ew") Wrapper<SystemIntroEntity> wrapper);

	List<SystemIntroView> selectListView(Pagination page,@Param("ew") Wrapper<SystemIntroEntity> wrapper);

	
	SystemIntroView selectView(@Param("ew") Wrapper<SystemIntroEntity> wrapper);
	

}

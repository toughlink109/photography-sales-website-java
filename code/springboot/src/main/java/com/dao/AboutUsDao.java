package com.dao;

import com.entity.AboutUsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AboutUsVO;
import com.entity.view.AboutUsView;


/**
 * 关于我们
 * 
 * @author 
 * @email 
 */
public interface AboutUsDao extends BaseMapper<AboutUsEntity> {
	
	List<AboutUsVO> selectListVO(@Param("ew") Wrapper<AboutUsEntity> wrapper);
	
	AboutUsVO selectVO(@Param("ew") Wrapper<AboutUsEntity> wrapper);
	
	List<AboutUsView> selectListView(@Param("ew") Wrapper<AboutUsEntity> wrapper);

	List<AboutUsView> selectListView(Pagination page,@Param("ew") Wrapper<AboutUsEntity> wrapper);

	
	AboutUsView selectView(@Param("ew") Wrapper<AboutUsEntity> wrapper);
	

}

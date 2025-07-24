package com.dao;

import com.entity.WorkCategoryEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WorkCategoryVO;
import com.entity.view.WorkCategoryView;


/**
 * 作品分类
 * 
 * @author 
 * @email 
 */
public interface WorkCategoryDao extends BaseMapper<WorkCategoryEntity> {
	
	List<WorkCategoryVO> selectListVO(@Param("ew") Wrapper<WorkCategoryEntity> wrapper);
	
	WorkCategoryVO selectVO(@Param("ew") Wrapper<WorkCategoryEntity> wrapper);
	
	List<WorkCategoryView> selectListView(@Param("ew") Wrapper<WorkCategoryEntity> wrapper);

	List<WorkCategoryView> selectListView(Pagination page,@Param("ew") Wrapper<WorkCategoryEntity> wrapper);

	
	WorkCategoryView selectView(@Param("ew") Wrapper<WorkCategoryEntity> wrapper);
	

}

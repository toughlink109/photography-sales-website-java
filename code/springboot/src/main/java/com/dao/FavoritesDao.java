package com.dao;

import com.entity.FavoritesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FavoritesVO;
import com.entity.view.FavoritesView;


/**
 * 收藏表
 * 
 * @author 
 * @email 
 */
public interface FavoritesDao extends BaseMapper<FavoritesEntity> {
	
	List<FavoritesVO> selectListVO(@Param("ew") Wrapper<FavoritesEntity> wrapper);
	
	FavoritesVO selectVO(@Param("ew") Wrapper<FavoritesEntity> wrapper);
	
	List<FavoritesView> selectListView(@Param("ew") Wrapper<FavoritesEntity> wrapper);

	List<FavoritesView> selectListView(Pagination page,@Param("ew") Wrapper<FavoritesEntity> wrapper);

	
	FavoritesView selectView(@Param("ew") Wrapper<FavoritesEntity> wrapper);
	

}

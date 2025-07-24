package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FavoritesEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FavoritesVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FavoritesView;


/**
 * 收藏表
 *
 * @author 
 * @email 
 */
public interface FavoritesService extends IService<FavoritesEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FavoritesVO> selectListVO(Wrapper<FavoritesEntity> wrapper);
   	
   	FavoritesVO selectVO(@Param("ew") Wrapper<FavoritesEntity> wrapper);
   	
   	List<FavoritesView> selectListView(Wrapper<FavoritesEntity> wrapper);
   	
   	FavoritesView selectView(@Param("ew") Wrapper<FavoritesEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FavoritesEntity> wrapper);

   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TopicCategoriesEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TopicCategoriesVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TopicCategoriesView;


/**
 * 话题分类
 *
 * @author 
 * @email 
 */
public interface TopicCategoriesService extends IService<TopicCategoriesEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TopicCategoriesVO> selectListVO(Wrapper<TopicCategoriesEntity> wrapper);
   	
   	TopicCategoriesVO selectVO(@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);
   	
   	List<TopicCategoriesView> selectListView(Wrapper<TopicCategoriesEntity> wrapper);
   	
   	TopicCategoriesView selectView(@Param("ew") Wrapper<TopicCategoriesEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TopicCategoriesEntity> wrapper);

   	

}


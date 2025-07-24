package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WorkCategoryEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WorkCategoryVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WorkCategoryView;


/**
 * 作品分类
 *
 * @author 
 * @email 
 */
public interface WorkCategoryService extends IService<WorkCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WorkCategoryVO> selectListVO(Wrapper<WorkCategoryEntity> wrapper);
   	
   	WorkCategoryVO selectVO(@Param("ew") Wrapper<WorkCategoryEntity> wrapper);
   	
   	List<WorkCategoryView> selectListView(Wrapper<WorkCategoryEntity> wrapper);
   	
   	WorkCategoryView selectView(@Param("ew") Wrapper<WorkCategoryEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WorkCategoryEntity> wrapper);

   	

}


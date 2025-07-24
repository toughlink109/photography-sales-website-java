package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WorkPublishEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WorkPublishVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WorkPublishView;


/**
 * 作品发布
 *
 * @author 
 * @email 
 */
public interface WorkPublishService extends IService<WorkPublishEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WorkPublishVO> selectListVO(Wrapper<WorkPublishEntity> wrapper);
   	
   	WorkPublishVO selectVO(@Param("ew") Wrapper<WorkPublishEntity> wrapper);
   	
   	List<WorkPublishView> selectListView(Wrapper<WorkPublishEntity> wrapper);
   	
   	WorkPublishView selectView(@Param("ew") Wrapper<WorkPublishEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WorkPublishEntity> wrapper);

   	

}


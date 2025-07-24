package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PhotographyTopicCommentsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PhotographyTopicCommentsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PhotographyTopicCommentsView;


/**
 * 摄影话题评论表
 *
 * @author 
 * @email 
 */
public interface PhotographyTopicCommentsService extends IService<PhotographyTopicCommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PhotographyTopicCommentsVO> selectListVO(Wrapper<PhotographyTopicCommentsEntity> wrapper);
   	
   	PhotographyTopicCommentsVO selectVO(@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);
   	
   	List<PhotographyTopicCommentsView> selectListView(Wrapper<PhotographyTopicCommentsEntity> wrapper);
   	
   	PhotographyTopicCommentsView selectView(@Param("ew") Wrapper<PhotographyTopicCommentsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PhotographyTopicCommentsEntity> wrapper);

   	

}


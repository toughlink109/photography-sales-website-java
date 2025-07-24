package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussWorkCommentsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussWorkCommentsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussWorkCommentsView;


/**
 * 摄影作品评论表
 *
 * @author 
 * @email 
 */
public interface DiscussWorkCommentsService extends IService<DiscussWorkCommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussWorkCommentsVO> selectListVO(Wrapper<DiscussWorkCommentsEntity> wrapper);
   	
   	DiscussWorkCommentsVO selectVO(@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);
   	
   	List<DiscussWorkCommentsView> selectListView(Wrapper<DiscussWorkCommentsEntity> wrapper);
   	
   	DiscussWorkCommentsView selectView(@Param("ew") Wrapper<DiscussWorkCommentsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussWorkCommentsEntity> wrapper);

   	

}


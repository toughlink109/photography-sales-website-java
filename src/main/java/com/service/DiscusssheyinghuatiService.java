package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssheyinghuatiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssheyinghuatiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssheyinghuatiView;


/**
 * 摄影话题评论表
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:39
 */
public interface DiscusssheyinghuatiService extends IService<DiscusssheyinghuatiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssheyinghuatiVO> selectListVO(Wrapper<DiscusssheyinghuatiEntity> wrapper);
   	
   	DiscusssheyinghuatiVO selectVO(@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);
   	
   	List<DiscusssheyinghuatiView> selectListView(Wrapper<DiscusssheyinghuatiEntity> wrapper);
   	
   	DiscusssheyinghuatiView selectView(@Param("ew") Wrapper<DiscusssheyinghuatiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssheyinghuatiEntity> wrapper);

   	

}


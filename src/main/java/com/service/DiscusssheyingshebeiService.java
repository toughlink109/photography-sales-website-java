package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssheyingshebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssheyingshebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssheyingshebeiView;


/**
 * 摄影设备评论表
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
public interface DiscusssheyingshebeiService extends IService<DiscusssheyingshebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssheyingshebeiVO> selectListVO(Wrapper<DiscusssheyingshebeiEntity> wrapper);
   	
   	DiscusssheyingshebeiVO selectVO(@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);
   	
   	List<DiscusssheyingshebeiView> selectListView(Wrapper<DiscusssheyingshebeiEntity> wrapper);
   	
   	DiscusssheyingshebeiView selectView(@Param("ew") Wrapper<DiscusssheyingshebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssheyingshebeiEntity> wrapper);

   	

}


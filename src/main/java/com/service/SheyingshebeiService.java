package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheyingshebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheyingshebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheyingshebeiView;


/**
 * 摄影设备
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyingshebeiService extends IService<SheyingshebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheyingshebeiVO> selectListVO(Wrapper<SheyingshebeiEntity> wrapper);
   	
   	SheyingshebeiVO selectVO(@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);
   	
   	List<SheyingshebeiView> selectListView(Wrapper<SheyingshebeiEntity> wrapper);
   	
   	SheyingshebeiView selectView(@Param("ew") Wrapper<SheyingshebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheyingshebeiEntity> wrapper);

   	

}


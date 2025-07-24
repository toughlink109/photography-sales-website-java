package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EquipmentCommentsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EquipmentCommentsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EquipmentCommentsView;


/**
 * 摄影设备评论表
 *
 * @author 
 * @email 
 */
public interface EquipmentCommentsService extends IService<EquipmentCommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EquipmentCommentsVO> selectListVO(Wrapper<EquipmentCommentsEntity> wrapper);
   	
   	EquipmentCommentsVO selectVO(@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);
   	
   	List<EquipmentCommentsView> selectListView(Wrapper<EquipmentCommentsEntity> wrapper);
   	
   	EquipmentCommentsView selectView(@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EquipmentCommentsEntity> wrapper);

   	

}


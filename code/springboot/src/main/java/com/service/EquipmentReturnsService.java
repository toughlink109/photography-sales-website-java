package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EquipmentReturnsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EquipmentReturnsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EquipmentReturnsView;


/**
 * 设备归还
 *
 * @author 
 * @email 
 */
public interface EquipmentReturnsService extends IService<EquipmentReturnsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<EquipmentReturnsVO> selectListVO(Wrapper<EquipmentReturnsEntity> wrapper);
   	
   	EquipmentReturnsVO selectVO(@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);
   	
   	List<EquipmentReturnsView> selectListView(Wrapper<EquipmentReturnsEntity> wrapper);
   	
   	EquipmentReturnsView selectView(@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<EquipmentReturnsEntity> wrapper);

   	

}


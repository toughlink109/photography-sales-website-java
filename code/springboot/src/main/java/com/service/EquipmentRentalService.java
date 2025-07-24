package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.EquipmentRentalEntity;
import com.utils.PageUtils;
import com.entity.EquipmentRentalEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.EquipmentRentalVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.EquipmentRentalView;


/**
 * 摄影设备租用
 *
 * @author
 * @email
 */
public interface EquipmentRentalService extends IService<EquipmentRentalEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<EquipmentRentalVO> selectListVO(Wrapper<EquipmentRentalEntity> wrapper);

   	EquipmentRentalVO selectVO(@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);

   	List<EquipmentRentalView> selectListView(Wrapper<EquipmentRentalEntity> wrapper);

   	EquipmentRentalView selectView(@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params,Wrapper<EquipmentRentalEntity> wrapper);



}


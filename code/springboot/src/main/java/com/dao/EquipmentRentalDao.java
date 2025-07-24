package com.dao;

import com.entity.EquipmentRentalEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EquipmentRentalVO;
import com.entity.view.EquipmentRentalView;


/**
 * 摄影设备租用
 *
 * @author
 * @email
 */
public interface EquipmentRentalDao extends BaseMapper<EquipmentRentalEntity> {

	List<EquipmentRentalVO> selectListVO(@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);

	EquipmentRentalVO selectVO(@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);

	List<EquipmentRentalView> selectListView(@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);

	List<EquipmentRentalView> selectListView(Pagination page,@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);


	EquipmentRentalView selectView(@Param("ew") Wrapper<EquipmentRentalEntity> wrapper);


}

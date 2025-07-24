package com.dao;

import com.entity.EquipmentReturnsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EquipmentReturnsVO;
import com.entity.view.EquipmentReturnsView;


/**
 * 设备归还
 * 
 * @author 
 * @email 
 */
public interface EquipmentReturnsDao extends BaseMapper<EquipmentReturnsEntity> {
	
	List<EquipmentReturnsVO> selectListVO(@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);
	
	EquipmentReturnsVO selectVO(@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);
	
	List<EquipmentReturnsView> selectListView(@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);

	List<EquipmentReturnsView> selectListView(Pagination page,@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);

	
	EquipmentReturnsView selectView(@Param("ew") Wrapper<EquipmentReturnsEntity> wrapper);
	

}

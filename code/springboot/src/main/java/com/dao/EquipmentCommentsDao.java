package com.dao;

import com.entity.EquipmentCommentsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.EquipmentCommentsVO;
import com.entity.view.EquipmentCommentsView;


/**
 * 摄影设备评论表
 * 
 * @author 
 * @email 
 */
public interface EquipmentCommentsDao extends BaseMapper<EquipmentCommentsEntity> {
	
	List<EquipmentCommentsVO> selectListVO(@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);
	
	EquipmentCommentsVO selectVO(@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);
	
	List<EquipmentCommentsView> selectListView(@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);

	List<EquipmentCommentsView> selectListView(Pagination page,@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);

	
	EquipmentCommentsView selectView(@Param("ew") Wrapper<EquipmentCommentsEntity> wrapper);
	

}

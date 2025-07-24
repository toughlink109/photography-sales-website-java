package com.dao;

import com.entity.PhotographyEquipmentsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PhotographyEquipmentsVO;
import com.entity.view.PhotographyEquipmentsView;


/**
 * 摄影设备
 * 
 * @author 
 * @email 
 */
public interface PhotographyEquipmentsDao extends BaseMapper<PhotographyEquipmentsEntity> {
	
	List<PhotographyEquipmentsVO> selectListVO(@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);
	
	PhotographyEquipmentsVO selectVO(@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);
	
	List<PhotographyEquipmentsView> selectListView(@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);

	List<PhotographyEquipmentsView> selectListView(Pagination page,@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);

	
	PhotographyEquipmentsView selectView(@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);
	

}

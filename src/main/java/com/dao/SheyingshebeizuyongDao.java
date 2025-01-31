package com.dao;

import com.entity.SheyingshebeizuyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheyingshebeizuyongVO;
import com.entity.view.SheyingshebeizuyongView;


/**
 * 摄影设备租用
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyingshebeizuyongDao extends BaseMapper<SheyingshebeizuyongEntity> {
	
	List<SheyingshebeizuyongVO> selectListVO(@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);
	
	SheyingshebeizuyongVO selectVO(@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);
	
	List<SheyingshebeizuyongView> selectListView(@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);

	List<SheyingshebeizuyongView> selectListView(Pagination page,@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);

	
	SheyingshebeizuyongView selectView(@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);
	

}

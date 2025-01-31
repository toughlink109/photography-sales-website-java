package com.dao;

import com.entity.HuatifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuatifenleiVO;
import com.entity.view.HuatifenleiView;


/**
 * 话题分类
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
public interface HuatifenleiDao extends BaseMapper<HuatifenleiEntity> {
	
	List<HuatifenleiVO> selectListVO(@Param("ew") Wrapper<HuatifenleiEntity> wrapper);
	
	HuatifenleiVO selectVO(@Param("ew") Wrapper<HuatifenleiEntity> wrapper);
	
	List<HuatifenleiView> selectListView(@Param("ew") Wrapper<HuatifenleiEntity> wrapper);

	List<HuatifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<HuatifenleiEntity> wrapper);

	
	HuatifenleiView selectView(@Param("ew") Wrapper<HuatifenleiEntity> wrapper);
	

}

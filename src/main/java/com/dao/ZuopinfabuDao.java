package com.dao;

import com.entity.ZuopinfabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuopinfabuVO;
import com.entity.view.ZuopinfabuView;


/**
 * 作品发布
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface ZuopinfabuDao extends BaseMapper<ZuopinfabuEntity> {
	
	List<ZuopinfabuVO> selectListVO(@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);
	
	ZuopinfabuVO selectVO(@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);
	
	List<ZuopinfabuView> selectListView(@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);

	List<ZuopinfabuView> selectListView(Pagination page,@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);

	
	ZuopinfabuView selectView(@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);
	

}

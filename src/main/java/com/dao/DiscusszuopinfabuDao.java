package com.dao;

import com.entity.DiscusszuopinfabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszuopinfabuVO;
import com.entity.view.DiscusszuopinfabuView;


/**
 * 作品发布评论表
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:39
 */
public interface DiscusszuopinfabuDao extends BaseMapper<DiscusszuopinfabuEntity> {
	
	List<DiscusszuopinfabuVO> selectListVO(@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);
	
	DiscusszuopinfabuVO selectVO(@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);
	
	List<DiscusszuopinfabuView> selectListView(@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);

	List<DiscusszuopinfabuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);

	
	DiscusszuopinfabuView selectView(@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);
	

}

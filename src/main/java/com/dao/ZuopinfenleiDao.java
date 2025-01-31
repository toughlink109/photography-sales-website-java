package com.dao;

import com.entity.ZuopinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuopinfenleiVO;
import com.entity.view.ZuopinfenleiView;


/**
 * 作品分类
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface ZuopinfenleiDao extends BaseMapper<ZuopinfenleiEntity> {
	
	List<ZuopinfenleiVO> selectListVO(@Param("ew") Wrapper<ZuopinfenleiEntity> wrapper);
	
	ZuopinfenleiVO selectVO(@Param("ew") Wrapper<ZuopinfenleiEntity> wrapper);
	
	List<ZuopinfenleiView> selectListView(@Param("ew") Wrapper<ZuopinfenleiEntity> wrapper);

	List<ZuopinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ZuopinfenleiEntity> wrapper);

	
	ZuopinfenleiView selectView(@Param("ew") Wrapper<ZuopinfenleiEntity> wrapper);
	

}

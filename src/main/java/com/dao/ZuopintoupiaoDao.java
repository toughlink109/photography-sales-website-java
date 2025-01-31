package com.dao;

import com.entity.ZuopintoupiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuopintoupiaoVO;
import com.entity.view.ZuopintoupiaoView;


/**
 * 作品投票
 * 
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
public interface ZuopintoupiaoDao extends BaseMapper<ZuopintoupiaoEntity> {
	
	List<ZuopintoupiaoVO> selectListVO(@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);
	
	ZuopintoupiaoVO selectVO(@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);
	
	List<ZuopintoupiaoView> selectListView(@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);

	List<ZuopintoupiaoView> selectListView(Pagination page,@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);

	
	ZuopintoupiaoView selectView(@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);
	

}

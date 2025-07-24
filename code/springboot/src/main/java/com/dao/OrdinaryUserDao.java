package com.dao;

import com.entity.OrdinaryUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.OrdinaryUserVO;
import com.entity.view.OrdinaryUserView;


/**
 * 用户
 * 
 * @author 
 * @email 
 */
public interface OrdinaryUserDao extends BaseMapper<OrdinaryUserEntity> {
	
	List<OrdinaryUserVO> selectListVO(@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);
	
	OrdinaryUserVO selectVO(@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);
	
	List<OrdinaryUserView> selectListView(@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);

	List<OrdinaryUserView> selectListView(Pagination page,@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);

	
	OrdinaryUserView selectView(@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);
	

}

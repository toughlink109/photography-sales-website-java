
package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AdminsEntity;

/**
 * 用户
 */
public interface AdminsDao extends BaseMapper<AdminsEntity> {
	
	List<AdminsEntity> selectListView(@Param("ew") Wrapper<AdminsEntity> wrapper);

	List<AdminsEntity> selectListView(Pagination page,@Param("ew") Wrapper<AdminsEntity> wrapper);
	
}


package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AdminsDao;
import com.entity.AdminsEntity;
import com.service.AdminsService;
import com.utils.PageUtils;
import com.utils.Query;


/**
 * 系统用户
 */
@Service("adminsService")
public class AdminsServiceImpl extends ServiceImpl<AdminsDao, AdminsEntity> implements AdminsService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<AdminsEntity> page = this.selectPage(
                new Query<AdminsEntity>(params).getPage(),
                new EntityWrapper<AdminsEntity>()
        );
        return new PageUtils(page);
	}

	@Override
	public List<AdminsEntity> selectListView(Wrapper<AdminsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params,
			Wrapper<AdminsEntity> wrapper) {
		 Page<AdminsEntity> page =new Query<AdminsEntity>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
	}
}

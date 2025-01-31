package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SheyinghuatiDao;
import com.entity.SheyinghuatiEntity;
import com.service.SheyinghuatiService;
import com.entity.vo.SheyinghuatiVO;
import com.entity.view.SheyinghuatiView;

@Service("sheyinghuatiService")
public class SheyinghuatiServiceImpl extends ServiceImpl<SheyinghuatiDao, SheyinghuatiEntity> implements SheyinghuatiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheyinghuatiEntity> page = this.selectPage(
                new Query<SheyinghuatiEntity>(params).getPage(),
                new EntityWrapper<SheyinghuatiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheyinghuatiEntity> wrapper) {
		  Page<SheyinghuatiView> page =new Query<SheyinghuatiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SheyinghuatiVO> selectListVO(Wrapper<SheyinghuatiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheyinghuatiVO selectVO(Wrapper<SheyinghuatiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheyinghuatiView> selectListView(Wrapper<SheyinghuatiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheyinghuatiView selectView(Wrapper<SheyinghuatiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

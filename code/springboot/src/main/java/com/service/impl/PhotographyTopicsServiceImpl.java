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


import com.dao.PhotographyTopicsDao;
import com.entity.PhotographyTopicsEntity;
import com.service.PhotographyTopicsService;
import com.entity.vo.PhotographyTopicsVO;
import com.entity.view.PhotographyTopicsView;

@Service("photographyTopicsService")
public class PhotographyTopicsServiceImpl extends ServiceImpl<PhotographyTopicsDao, PhotographyTopicsEntity> implements PhotographyTopicsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PhotographyTopicsEntity> page = this.selectPage(
                new Query<PhotographyTopicsEntity>(params).getPage(),
                new EntityWrapper<PhotographyTopicsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PhotographyTopicsEntity> wrapper) {
		  Page<PhotographyTopicsView> page =new Query<PhotographyTopicsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PhotographyTopicsVO> selectListVO(Wrapper<PhotographyTopicsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PhotographyTopicsVO selectVO(Wrapper<PhotographyTopicsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PhotographyTopicsView> selectListView(Wrapper<PhotographyTopicsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PhotographyTopicsView selectView(Wrapper<PhotographyTopicsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

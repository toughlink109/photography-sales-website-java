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


import com.dao.DiscusssheyinghuatiDao;
import com.entity.DiscusssheyinghuatiEntity;
import com.service.DiscusssheyinghuatiService;
import com.entity.vo.DiscusssheyinghuatiVO;
import com.entity.view.DiscusssheyinghuatiView;

@Service("discusssheyinghuatiService")
public class DiscusssheyinghuatiServiceImpl extends ServiceImpl<DiscusssheyinghuatiDao, DiscusssheyinghuatiEntity> implements DiscusssheyinghuatiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssheyinghuatiEntity> page = this.selectPage(
                new Query<DiscusssheyinghuatiEntity>(params).getPage(),
                new EntityWrapper<DiscusssheyinghuatiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssheyinghuatiEntity> wrapper) {
		  Page<DiscusssheyinghuatiView> page =new Query<DiscusssheyinghuatiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusssheyinghuatiVO> selectListVO(Wrapper<DiscusssheyinghuatiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusssheyinghuatiVO selectVO(Wrapper<DiscusssheyinghuatiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusssheyinghuatiView> selectListView(Wrapper<DiscusssheyinghuatiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssheyinghuatiView selectView(Wrapper<DiscusssheyinghuatiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

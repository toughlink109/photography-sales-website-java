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


import com.dao.DiscusssheyingshebeiDao;
import com.entity.DiscusssheyingshebeiEntity;
import com.service.DiscusssheyingshebeiService;
import com.entity.vo.DiscusssheyingshebeiVO;
import com.entity.view.DiscusssheyingshebeiView;

@Service("discusssheyingshebeiService")
public class DiscusssheyingshebeiServiceImpl extends ServiceImpl<DiscusssheyingshebeiDao, DiscusssheyingshebeiEntity> implements DiscusssheyingshebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssheyingshebeiEntity> page = this.selectPage(
                new Query<DiscusssheyingshebeiEntity>(params).getPage(),
                new EntityWrapper<DiscusssheyingshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssheyingshebeiEntity> wrapper) {
		  Page<DiscusssheyingshebeiView> page =new Query<DiscusssheyingshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusssheyingshebeiVO> selectListVO(Wrapper<DiscusssheyingshebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusssheyingshebeiVO selectVO(Wrapper<DiscusssheyingshebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusssheyingshebeiView> selectListView(Wrapper<DiscusssheyingshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssheyingshebeiView selectView(Wrapper<DiscusssheyingshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

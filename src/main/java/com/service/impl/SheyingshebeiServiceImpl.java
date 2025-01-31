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


import com.dao.SheyingshebeiDao;
import com.entity.SheyingshebeiEntity;
import com.service.SheyingshebeiService;
import com.entity.vo.SheyingshebeiVO;
import com.entity.view.SheyingshebeiView;

@Service("sheyingshebeiService")
public class SheyingshebeiServiceImpl extends ServiceImpl<SheyingshebeiDao, SheyingshebeiEntity> implements SheyingshebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheyingshebeiEntity> page = this.selectPage(
                new Query<SheyingshebeiEntity>(params).getPage(),
                new EntityWrapper<SheyingshebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheyingshebeiEntity> wrapper) {
		  Page<SheyingshebeiView> page =new Query<SheyingshebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SheyingshebeiVO> selectListVO(Wrapper<SheyingshebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheyingshebeiVO selectVO(Wrapper<SheyingshebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheyingshebeiView> selectListView(Wrapper<SheyingshebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheyingshebeiView selectView(Wrapper<SheyingshebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

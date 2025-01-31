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


import com.dao.SheyinghuodongDao;
import com.entity.SheyinghuodongEntity;
import com.service.SheyinghuodongService;
import com.entity.vo.SheyinghuodongVO;
import com.entity.view.SheyinghuodongView;

@Service("sheyinghuodongService")
public class SheyinghuodongServiceImpl extends ServiceImpl<SheyinghuodongDao, SheyinghuodongEntity> implements SheyinghuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheyinghuodongEntity> page = this.selectPage(
                new Query<SheyinghuodongEntity>(params).getPage(),
                new EntityWrapper<SheyinghuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheyinghuodongEntity> wrapper) {
		  Page<SheyinghuodongView> page =new Query<SheyinghuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SheyinghuodongVO> selectListVO(Wrapper<SheyinghuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheyinghuodongVO selectVO(Wrapper<SheyinghuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheyinghuodongView> selectListView(Wrapper<SheyinghuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheyinghuodongView selectView(Wrapper<SheyinghuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

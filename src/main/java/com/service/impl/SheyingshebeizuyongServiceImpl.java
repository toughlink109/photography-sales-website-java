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


import com.dao.SheyingshebeizuyongDao;
import com.entity.SheyingshebeizuyongEntity;
import com.service.SheyingshebeizuyongService;
import com.entity.vo.SheyingshebeizuyongVO;
import com.entity.view.SheyingshebeizuyongView;

@Service("sheyingshebeizuyongService")
public class SheyingshebeizuyongServiceImpl extends ServiceImpl<SheyingshebeizuyongDao, SheyingshebeizuyongEntity> implements SheyingshebeizuyongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheyingshebeizuyongEntity> page = this.selectPage(
                new Query<SheyingshebeizuyongEntity>(params).getPage(),
                new EntityWrapper<SheyingshebeizuyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheyingshebeizuyongEntity> wrapper) {
		  Page<SheyingshebeizuyongView> page =new Query<SheyingshebeizuyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SheyingshebeizuyongVO> selectListVO(Wrapper<SheyingshebeizuyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheyingshebeizuyongVO selectVO(Wrapper<SheyingshebeizuyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheyingshebeizuyongView> selectListView(Wrapper<SheyingshebeizuyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheyingshebeizuyongView selectView(Wrapper<SheyingshebeizuyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

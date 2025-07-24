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


import com.dao.EventsDao;
import com.entity.EventsEntity;
import com.service.EventsService;
import com.entity.vo.EventsVO;
import com.entity.view.EventsView;

@Service("eventsService")
public class EventsServiceImpl extends ServiceImpl<EventsDao, EventsEntity> implements EventsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EventsEntity> page = this.selectPage(
                new Query<EventsEntity>(params).getPage(),
                new EntityWrapper<EventsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EventsEntity> wrapper) {
		  Page<EventsView> page =new Query<EventsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<EventsVO> selectListVO(Wrapper<EventsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EventsVO selectVO(Wrapper<EventsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EventsView> selectListView(Wrapper<EventsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EventsView selectView(Wrapper<EventsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

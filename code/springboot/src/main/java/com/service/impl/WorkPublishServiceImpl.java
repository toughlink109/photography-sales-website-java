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


import com.dao.WorkPublishDao;
import com.entity.WorkPublishEntity;
import com.service.WorkPublishService;
import com.entity.vo.WorkPublishVO;
import com.entity.view.WorkPublishView;

@Service("workPublishService")
public class WorkPublishServiceImpl extends ServiceImpl<WorkPublishDao, WorkPublishEntity> implements WorkPublishService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkPublishEntity> page = this.selectPage(
                new Query<WorkPublishEntity>(params).getPage(),
                new EntityWrapper<WorkPublishEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WorkPublishEntity> wrapper) {
		  Page<WorkPublishView> page =new Query<WorkPublishView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WorkPublishVO> selectListVO(Wrapper<WorkPublishEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WorkPublishVO selectVO(Wrapper<WorkPublishEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WorkPublishView> selectListView(Wrapper<WorkPublishEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WorkPublishView selectView(Wrapper<WorkPublishEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

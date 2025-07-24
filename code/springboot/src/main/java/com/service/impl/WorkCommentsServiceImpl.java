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


import com.dao.WorkCommentsDao;
import com.entity.WorkCommentsEntity;
import com.service.WorkCommentsService;
import com.entity.vo.WorkCommentsVO;
import com.entity.view.WorkCommentsView;

@Service("workCommentsService")
public class WorkCommentsServiceImpl extends ServiceImpl<WorkCommentsDao, WorkCommentsEntity> implements WorkCommentsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkCommentsEntity> page = this.selectPage(
                new Query<WorkCommentsEntity>(params).getPage(),
                new EntityWrapper<WorkCommentsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WorkCommentsEntity> wrapper) {
		  Page<WorkCommentsView> page =new Query<WorkCommentsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WorkCommentsVO> selectListVO(Wrapper<WorkCommentsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WorkCommentsVO selectVO(Wrapper<WorkCommentsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WorkCommentsView> selectListView(Wrapper<WorkCommentsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WorkCommentsView selectView(Wrapper<WorkCommentsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

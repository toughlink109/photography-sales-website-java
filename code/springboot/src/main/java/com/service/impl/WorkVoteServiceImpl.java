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


import com.dao.WorkVoteDao;
import com.entity.WorkVoteEntity;
import com.service.WorkVoteService;
import com.entity.vo.WorkVoteVO;
import com.entity.view.WorkVoteView;

@Service("workVoteService")
public class WorkVoteServiceImpl extends ServiceImpl<WorkVoteDao, WorkVoteEntity> implements WorkVoteService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkVoteEntity> page = this.selectPage(
                new Query<WorkVoteEntity>(params).getPage(),
                new EntityWrapper<WorkVoteEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WorkVoteEntity> wrapper) {
		  Page<WorkVoteView> page =new Query<WorkVoteView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WorkVoteVO> selectListVO(Wrapper<WorkVoteEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WorkVoteVO selectVO(Wrapper<WorkVoteEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WorkVoteView> selectListView(Wrapper<WorkVoteEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WorkVoteView selectView(Wrapper<WorkVoteEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

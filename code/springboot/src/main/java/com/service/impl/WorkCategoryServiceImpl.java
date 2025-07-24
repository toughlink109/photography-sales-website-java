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


import com.dao.WorkCategoryDao;
import com.entity.WorkCategoryEntity;
import com.service.WorkCategoryService;
import com.entity.vo.WorkCategoryVO;
import com.entity.view.WorkCategoryView;

@Service("workCategoryService")
public class WorkCategoryServiceImpl extends ServiceImpl<WorkCategoryDao, WorkCategoryEntity> implements WorkCategoryService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WorkCategoryEntity> page = this.selectPage(
                new Query<WorkCategoryEntity>(params).getPage(),
                new EntityWrapper<WorkCategoryEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WorkCategoryEntity> wrapper) {
		  Page<WorkCategoryView> page =new Query<WorkCategoryView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WorkCategoryVO> selectListVO(Wrapper<WorkCategoryEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WorkCategoryVO selectVO(Wrapper<WorkCategoryEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WorkCategoryView> selectListView(Wrapper<WorkCategoryEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WorkCategoryView selectView(Wrapper<WorkCategoryEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

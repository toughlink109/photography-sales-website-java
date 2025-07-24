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


import com.dao.TopicCategoriesDao;
import com.entity.TopicCategoriesEntity;
import com.service.TopicCategoriesService;
import com.entity.vo.TopicCategoriesVO;
import com.entity.view.TopicCategoriesView;

@Service("topicCategoriesService")
public class TopicCategoriesServiceImpl extends ServiceImpl<TopicCategoriesDao, TopicCategoriesEntity> implements TopicCategoriesService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TopicCategoriesEntity> page = this.selectPage(
                new Query<TopicCategoriesEntity>(params).getPage(),
                new EntityWrapper<TopicCategoriesEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TopicCategoriesEntity> wrapper) {
		  Page<TopicCategoriesView> page =new Query<TopicCategoriesView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TopicCategoriesVO> selectListVO(Wrapper<TopicCategoriesEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TopicCategoriesVO selectVO(Wrapper<TopicCategoriesEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TopicCategoriesView> selectListView(Wrapper<TopicCategoriesEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TopicCategoriesView selectView(Wrapper<TopicCategoriesEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

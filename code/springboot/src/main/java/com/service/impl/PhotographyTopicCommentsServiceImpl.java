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


import com.dao.PhotographyTopicCommentsDao;
import com.entity.PhotographyTopicCommentsEntity;
import com.service.PhotographyTopicCommentsService;
import com.entity.vo.PhotographyTopicCommentsVO;
import com.entity.view.PhotographyTopicCommentsView;

@Service("photographyTopicCommentsService")
public class PhotographyTopicCommentsServiceImpl extends ServiceImpl<PhotographyTopicCommentsDao, PhotographyTopicCommentsEntity> implements PhotographyTopicCommentsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PhotographyTopicCommentsEntity> page = this.selectPage(
                new Query<PhotographyTopicCommentsEntity>(params).getPage(),
                new EntityWrapper<PhotographyTopicCommentsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PhotographyTopicCommentsEntity> wrapper) {
		  Page<PhotographyTopicCommentsView> page =new Query<PhotographyTopicCommentsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PhotographyTopicCommentsVO> selectListVO(Wrapper<PhotographyTopicCommentsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PhotographyTopicCommentsVO selectVO(Wrapper<PhotographyTopicCommentsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PhotographyTopicCommentsView> selectListView(Wrapper<PhotographyTopicCommentsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PhotographyTopicCommentsView selectView(Wrapper<PhotographyTopicCommentsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

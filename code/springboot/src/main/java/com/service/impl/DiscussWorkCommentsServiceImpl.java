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


import com.dao.DiscussWorkCommentsDao;
import com.entity.DiscussWorkCommentsEntity;
import com.service.DiscussWorkCommentsService;
import com.entity.vo.DiscussWorkCommentsVO;
import com.entity.view.DiscussWorkCommentsView;

@Service("discussWorkCommentsService")
public class DiscussWorkCommentsServiceImpl extends ServiceImpl<DiscussWorkCommentsDao, DiscussWorkCommentsEntity> implements DiscussWorkCommentsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussWorkCommentsEntity> page = this.selectPage(
                new Query<DiscussWorkCommentsEntity>(params).getPage(),
                new EntityWrapper<DiscussWorkCommentsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussWorkCommentsEntity> wrapper) {
		  Page<DiscussWorkCommentsView> page =new Query<DiscussWorkCommentsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussWorkCommentsVO> selectListVO(Wrapper<DiscussWorkCommentsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussWorkCommentsVO selectVO(Wrapper<DiscussWorkCommentsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussWorkCommentsView> selectListView(Wrapper<DiscussWorkCommentsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussWorkCommentsView selectView(Wrapper<DiscussWorkCommentsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

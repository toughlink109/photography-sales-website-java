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


import com.dao.PhotographyWorksDao;
import com.entity.PhotographyWorksEntity;
import com.service.PhotographyWorksService;
import com.entity.vo.PhotographyWorksVO;
import com.entity.view.PhotographyWorksView;

@Service("photographyWorksService")
public class PhotographyWorksServiceImpl extends ServiceImpl<PhotographyWorksDao, PhotographyWorksEntity> implements PhotographyWorksService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PhotographyWorksEntity> page = this.selectPage(
                new Query<PhotographyWorksEntity>(params).getPage(),
                new EntityWrapper<PhotographyWorksEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PhotographyWorksEntity> wrapper) {
		  Page<PhotographyWorksView> page =new Query<PhotographyWorksView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PhotographyWorksVO> selectListVO(Wrapper<PhotographyWorksEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PhotographyWorksVO selectVO(Wrapper<PhotographyWorksEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PhotographyWorksView> selectListView(Wrapper<PhotographyWorksEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PhotographyWorksView selectView(Wrapper<PhotographyWorksEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

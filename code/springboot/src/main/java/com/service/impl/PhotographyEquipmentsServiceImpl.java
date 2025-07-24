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


import com.dao.PhotographyEquipmentsDao;
import com.entity.PhotographyEquipmentsEntity;
import com.service.PhotographyEquipmentsService;
import com.entity.vo.PhotographyEquipmentsVO;
import com.entity.view.PhotographyEquipmentsView;

@Service("photographyEquipmentsService")
public class PhotographyEquipmentsServiceImpl extends ServiceImpl<PhotographyEquipmentsDao, PhotographyEquipmentsEntity> implements PhotographyEquipmentsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PhotographyEquipmentsEntity> page = this.selectPage(
                new Query<PhotographyEquipmentsEntity>(params).getPage(),
                new EntityWrapper<PhotographyEquipmentsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PhotographyEquipmentsEntity> wrapper) {
		  Page<PhotographyEquipmentsView> page =new Query<PhotographyEquipmentsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PhotographyEquipmentsVO> selectListVO(Wrapper<PhotographyEquipmentsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PhotographyEquipmentsVO selectVO(Wrapper<PhotographyEquipmentsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PhotographyEquipmentsView> selectListView(Wrapper<PhotographyEquipmentsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PhotographyEquipmentsView selectView(Wrapper<PhotographyEquipmentsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

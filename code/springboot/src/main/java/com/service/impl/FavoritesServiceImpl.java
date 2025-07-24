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


import com.dao.FavoritesDao;
import com.entity.FavoritesEntity;
import com.service.FavoritesService;
import com.entity.vo.FavoritesVO;
import com.entity.view.FavoritesView;

@Service("favoritesService")
public class FavoritesServiceImpl extends ServiceImpl<FavoritesDao, FavoritesEntity> implements FavoritesService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FavoritesEntity> page = this.selectPage(
                new Query<FavoritesEntity>(params).getPage(),
                new EntityWrapper<FavoritesEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FavoritesEntity> wrapper) {
		  Page<FavoritesView> page =new Query<FavoritesView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FavoritesVO> selectListVO(Wrapper<FavoritesEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FavoritesVO selectVO(Wrapper<FavoritesEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FavoritesView> selectListView(Wrapper<FavoritesEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FavoritesView selectView(Wrapper<FavoritesEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

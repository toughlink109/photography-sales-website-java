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


import com.dao.ZuopintoupiaoDao;
import com.entity.ZuopintoupiaoEntity;
import com.service.ZuopintoupiaoService;
import com.entity.vo.ZuopintoupiaoVO;
import com.entity.view.ZuopintoupiaoView;

@Service("zuopintoupiaoService")
public class ZuopintoupiaoServiceImpl extends ServiceImpl<ZuopintoupiaoDao, ZuopintoupiaoEntity> implements ZuopintoupiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuopintoupiaoEntity> page = this.selectPage(
                new Query<ZuopintoupiaoEntity>(params).getPage(),
                new EntityWrapper<ZuopintoupiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuopintoupiaoEntity> wrapper) {
		  Page<ZuopintoupiaoView> page =new Query<ZuopintoupiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZuopintoupiaoVO> selectListVO(Wrapper<ZuopintoupiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuopintoupiaoVO selectVO(Wrapper<ZuopintoupiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuopintoupiaoView> selectListView(Wrapper<ZuopintoupiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuopintoupiaoView selectView(Wrapper<ZuopintoupiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

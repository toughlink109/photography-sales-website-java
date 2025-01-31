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


import com.dao.ZuopinfabuDao;
import com.entity.ZuopinfabuEntity;
import com.service.ZuopinfabuService;
import com.entity.vo.ZuopinfabuVO;
import com.entity.view.ZuopinfabuView;

@Service("zuopinfabuService")
public class ZuopinfabuServiceImpl extends ServiceImpl<ZuopinfabuDao, ZuopinfabuEntity> implements ZuopinfabuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuopinfabuEntity> page = this.selectPage(
                new Query<ZuopinfabuEntity>(params).getPage(),
                new EntityWrapper<ZuopinfabuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuopinfabuEntity> wrapper) {
		  Page<ZuopinfabuView> page =new Query<ZuopinfabuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZuopinfabuVO> selectListVO(Wrapper<ZuopinfabuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuopinfabuVO selectVO(Wrapper<ZuopinfabuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuopinfabuView> selectListView(Wrapper<ZuopinfabuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuopinfabuView selectView(Wrapper<ZuopinfabuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

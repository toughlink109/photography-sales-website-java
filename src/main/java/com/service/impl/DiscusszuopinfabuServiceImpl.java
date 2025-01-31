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


import com.dao.DiscusszuopinfabuDao;
import com.entity.DiscusszuopinfabuEntity;
import com.service.DiscusszuopinfabuService;
import com.entity.vo.DiscusszuopinfabuVO;
import com.entity.view.DiscusszuopinfabuView;

@Service("discusszuopinfabuService")
public class DiscusszuopinfabuServiceImpl extends ServiceImpl<DiscusszuopinfabuDao, DiscusszuopinfabuEntity> implements DiscusszuopinfabuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszuopinfabuEntity> page = this.selectPage(
                new Query<DiscusszuopinfabuEntity>(params).getPage(),
                new EntityWrapper<DiscusszuopinfabuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszuopinfabuEntity> wrapper) {
		  Page<DiscusszuopinfabuView> page =new Query<DiscusszuopinfabuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusszuopinfabuVO> selectListVO(Wrapper<DiscusszuopinfabuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszuopinfabuVO selectVO(Wrapper<DiscusszuopinfabuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszuopinfabuView> selectListView(Wrapper<DiscusszuopinfabuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszuopinfabuView selectView(Wrapper<DiscusszuopinfabuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

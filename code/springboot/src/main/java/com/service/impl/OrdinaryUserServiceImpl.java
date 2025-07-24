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


import com.dao.OrdinaryUserDao;
import com.entity.OrdinaryUserEntity;
import com.service.OrdinaryUserService;
import com.entity.vo.OrdinaryUserVO;
import com.entity.view.OrdinaryUserView;

@Service("ordinaryUserService")
public class OrdinaryUserServiceImpl extends ServiceImpl<OrdinaryUserDao, OrdinaryUserEntity> implements OrdinaryUserService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrdinaryUserEntity> page = this.selectPage(
                new Query<OrdinaryUserEntity>(params).getPage(),
                new EntityWrapper<OrdinaryUserEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<OrdinaryUserEntity> wrapper) {
		  Page<OrdinaryUserView> page =new Query<OrdinaryUserView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<OrdinaryUserVO> selectListVO(Wrapper<OrdinaryUserEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public OrdinaryUserVO selectVO(Wrapper<OrdinaryUserEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<OrdinaryUserView> selectListView(Wrapper<OrdinaryUserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public OrdinaryUserView selectView(Wrapper<OrdinaryUserEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

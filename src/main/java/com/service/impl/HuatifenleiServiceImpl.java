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


import com.dao.HuatifenleiDao;
import com.entity.HuatifenleiEntity;
import com.service.HuatifenleiService;
import com.entity.vo.HuatifenleiVO;
import com.entity.view.HuatifenleiView;

@Service("huatifenleiService")
public class HuatifenleiServiceImpl extends ServiceImpl<HuatifenleiDao, HuatifenleiEntity> implements HuatifenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuatifenleiEntity> page = this.selectPage(
                new Query<HuatifenleiEntity>(params).getPage(),
                new EntityWrapper<HuatifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuatifenleiEntity> wrapper) {
		  Page<HuatifenleiView> page =new Query<HuatifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<HuatifenleiVO> selectListVO(Wrapper<HuatifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuatifenleiVO selectVO(Wrapper<HuatifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuatifenleiView> selectListView(Wrapper<HuatifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuatifenleiView selectView(Wrapper<HuatifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.dao.EquipmentReturnsDao;
import com.entity.EquipmentReturnsEntity;
import com.service.EquipmentReturnsService;
import com.entity.vo.EquipmentReturnsVO;
import com.entity.view.EquipmentReturnsView;

@Service("equipmentReturnsService")
public class EquipmentReturnsServiceImpl extends ServiceImpl<EquipmentReturnsDao, EquipmentReturnsEntity> implements EquipmentReturnsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EquipmentReturnsEntity> page = this.selectPage(
                new Query<EquipmentReturnsEntity>(params).getPage(),
                new EntityWrapper<EquipmentReturnsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EquipmentReturnsEntity> wrapper) {
		  Page<EquipmentReturnsView> page =new Query<EquipmentReturnsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<EquipmentReturnsVO> selectListVO(Wrapper<EquipmentReturnsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EquipmentReturnsVO selectVO(Wrapper<EquipmentReturnsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EquipmentReturnsView> selectListView(Wrapper<EquipmentReturnsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EquipmentReturnsView selectView(Wrapper<EquipmentReturnsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

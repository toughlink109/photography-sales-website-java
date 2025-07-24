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


import com.dao.EquipmentCommentsDao;
import com.entity.EquipmentCommentsEntity;
import com.service.EquipmentCommentsService;
import com.entity.vo.EquipmentCommentsVO;
import com.entity.view.EquipmentCommentsView;

@Service("equipmentCommentsService")
public class EquipmentCommentsServiceImpl extends ServiceImpl<EquipmentCommentsDao, EquipmentCommentsEntity> implements EquipmentCommentsService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EquipmentCommentsEntity> page = this.selectPage(
                new Query<EquipmentCommentsEntity>(params).getPage(),
                new EntityWrapper<EquipmentCommentsEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EquipmentCommentsEntity> wrapper) {
		  Page<EquipmentCommentsView> page =new Query<EquipmentCommentsView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<EquipmentCommentsVO> selectListVO(Wrapper<EquipmentCommentsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public EquipmentCommentsVO selectVO(Wrapper<EquipmentCommentsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<EquipmentCommentsView> selectListView(Wrapper<EquipmentCommentsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EquipmentCommentsView selectView(Wrapper<EquipmentCommentsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

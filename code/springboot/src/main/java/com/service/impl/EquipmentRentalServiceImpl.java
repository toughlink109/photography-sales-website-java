package com.service.impl;

import com.service.EquipmentRentalService;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.EquipmentRentalDao;
import com.entity.EquipmentRentalEntity;
import com.entity.vo.EquipmentRentalVO;
import com.entity.view.EquipmentRentalView;

@Service("EquipmentRentalService")
public class EquipmentRentalServiceImpl extends ServiceImpl<EquipmentRentalDao, EquipmentRentalEntity> implements EquipmentRentalService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EquipmentRentalEntity> page = this.selectPage(
                new Query<EquipmentRentalEntity>(params).getPage(),
                new EntityWrapper<EquipmentRentalEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<EquipmentRentalEntity> wrapper) {
		  Page<EquipmentRentalView> page =new Query<EquipmentRentalView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}


    @Override
	public List<EquipmentRentalVO> selectListVO(Wrapper<EquipmentRentalEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public EquipmentRentalVO selectVO(Wrapper<EquipmentRentalEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<EquipmentRentalView> selectListView(Wrapper<EquipmentRentalEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public EquipmentRentalView selectView(Wrapper<EquipmentRentalEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

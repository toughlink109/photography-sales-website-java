package com.dao;

import com.entity.ActivityRegistrationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ActivityRegistrationVO;
import com.entity.view.ActivityRegistrationView;


/**
 * 报名活动
 * 
 * @author 
 * @email 
 */
public interface ActivityRegistrationDao extends BaseMapper<ActivityRegistrationEntity> {
	
	List<ActivityRegistrationVO> selectListVO(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	
	ActivityRegistrationVO selectVO(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	
	List<ActivityRegistrationView> selectListView(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);

	List<ActivityRegistrationView> selectListView(Pagination page,@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);

	
	ActivityRegistrationView selectView(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	

}

package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ActivityRegistrationEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ActivityRegistrationVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ActivityRegistrationView;


/**
 * 报名活动
 *
 * @author 
 * @email 
 */
public interface ActivityRegistrationService extends IService<ActivityRegistrationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ActivityRegistrationVO> selectListVO(Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	ActivityRegistrationVO selectVO(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	List<ActivityRegistrationView> selectListView(Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	ActivityRegistrationView selectView(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityRegistrationEntity> wrapper);

   	

}


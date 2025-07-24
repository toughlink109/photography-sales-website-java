package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SystemIntroEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SystemIntroVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SystemIntroView;


/**
 * 系统简介
 *
 * @author 
 * @email 
 */
public interface SystemIntroService extends IService<SystemIntroEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SystemIntroVO> selectListVO(Wrapper<SystemIntroEntity> wrapper);
   	
   	SystemIntroVO selectVO(@Param("ew") Wrapper<SystemIntroEntity> wrapper);
   	
   	List<SystemIntroView> selectListView(Wrapper<SystemIntroEntity> wrapper);
   	
   	SystemIntroView selectView(@Param("ew") Wrapper<SystemIntroEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SystemIntroEntity> wrapper);

   	

}


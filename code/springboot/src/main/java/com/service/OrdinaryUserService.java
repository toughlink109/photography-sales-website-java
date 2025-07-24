package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.OrdinaryUserEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.OrdinaryUserVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.OrdinaryUserView;


/**
 * 用户
 *
 * @author 
 * @email 
 */
public interface OrdinaryUserService extends IService<OrdinaryUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<OrdinaryUserVO> selectListVO(Wrapper<OrdinaryUserEntity> wrapper);
   	
   	OrdinaryUserVO selectVO(@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);
   	
   	List<OrdinaryUserView> selectListView(Wrapper<OrdinaryUserEntity> wrapper);
   	
   	OrdinaryUserView selectView(@Param("ew") Wrapper<OrdinaryUserEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<OrdinaryUserEntity> wrapper);

   	

}


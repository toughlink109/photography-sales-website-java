package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheyingshebeizuyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheyingshebeizuyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheyingshebeizuyongView;


/**
 * 摄影设备租用
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface SheyingshebeizuyongService extends IService<SheyingshebeizuyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheyingshebeizuyongVO> selectListVO(Wrapper<SheyingshebeizuyongEntity> wrapper);
   	
   	SheyingshebeizuyongVO selectVO(@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);
   	
   	List<SheyingshebeizuyongView> selectListView(Wrapper<SheyingshebeizuyongEntity> wrapper);
   	
   	SheyingshebeizuyongView selectView(@Param("ew") Wrapper<SheyingshebeizuyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheyingshebeizuyongEntity> wrapper);

   	

}


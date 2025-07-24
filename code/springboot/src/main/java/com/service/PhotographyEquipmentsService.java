package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PhotographyEquipmentsEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PhotographyEquipmentsVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PhotographyEquipmentsView;


/**
 * 摄影设备
 *
 * @author 
 * @email 
 */
public interface PhotographyEquipmentsService extends IService<PhotographyEquipmentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PhotographyEquipmentsVO> selectListVO(Wrapper<PhotographyEquipmentsEntity> wrapper);
   	
   	PhotographyEquipmentsVO selectVO(@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);
   	
   	List<PhotographyEquipmentsView> selectListView(Wrapper<PhotographyEquipmentsEntity> wrapper);
   	
   	PhotographyEquipmentsView selectView(@Param("ew") Wrapper<PhotographyEquipmentsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PhotographyEquipmentsEntity> wrapper);

   	

}


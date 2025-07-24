package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PhotographyWorksEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PhotographyWorksVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PhotographyWorksView;


/**
 * 摄影作品
 *
 * @author 
 * @email 
 */
public interface PhotographyWorksService extends IService<PhotographyWorksEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PhotographyWorksVO> selectListVO(Wrapper<PhotographyWorksEntity> wrapper);
   	
   	PhotographyWorksVO selectVO(@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);
   	
   	List<PhotographyWorksView> selectListView(Wrapper<PhotographyWorksEntity> wrapper);
   	
   	PhotographyWorksView selectView(@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PhotographyWorksEntity> wrapper);

   	

}


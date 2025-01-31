package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuatifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuatifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuatifenleiView;


/**
 * 话题分类
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
public interface HuatifenleiService extends IService<HuatifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuatifenleiVO> selectListVO(Wrapper<HuatifenleiEntity> wrapper);
   	
   	HuatifenleiVO selectVO(@Param("ew") Wrapper<HuatifenleiEntity> wrapper);
   	
   	List<HuatifenleiView> selectListView(Wrapper<HuatifenleiEntity> wrapper);
   	
   	HuatifenleiView selectView(@Param("ew") Wrapper<HuatifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuatifenleiEntity> wrapper);

   	

}


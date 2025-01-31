package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuopinfabuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuopinfabuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuopinfabuView;


/**
 * 作品发布
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
public interface ZuopinfabuService extends IService<ZuopinfabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuopinfabuVO> selectListVO(Wrapper<ZuopinfabuEntity> wrapper);
   	
   	ZuopinfabuVO selectVO(@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);
   	
   	List<ZuopinfabuView> selectListView(Wrapper<ZuopinfabuEntity> wrapper);
   	
   	ZuopinfabuView selectView(@Param("ew") Wrapper<ZuopinfabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuopinfabuEntity> wrapper);

   	

}


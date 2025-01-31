package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszuopinfabuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszuopinfabuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszuopinfabuView;


/**
 * 作品发布评论表
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:39
 */
public interface DiscusszuopinfabuService extends IService<DiscusszuopinfabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszuopinfabuVO> selectListVO(Wrapper<DiscusszuopinfabuEntity> wrapper);
   	
   	DiscusszuopinfabuVO selectVO(@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);
   	
   	List<DiscusszuopinfabuView> selectListView(Wrapper<DiscusszuopinfabuEntity> wrapper);
   	
   	DiscusszuopinfabuView selectView(@Param("ew") Wrapper<DiscusszuopinfabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszuopinfabuEntity> wrapper);

   	

}


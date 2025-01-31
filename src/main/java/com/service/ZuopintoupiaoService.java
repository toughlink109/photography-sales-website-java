package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZuopintoupiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZuopintoupiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuopintoupiaoView;


/**
 * 作品投票
 *
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
public interface ZuopintoupiaoService extends IService<ZuopintoupiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuopintoupiaoVO> selectListVO(Wrapper<ZuopintoupiaoEntity> wrapper);
   	
   	ZuopintoupiaoVO selectVO(@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);
   	
   	List<ZuopintoupiaoView> selectListView(Wrapper<ZuopintoupiaoEntity> wrapper);
   	
   	ZuopintoupiaoView selectView(@Param("ew") Wrapper<ZuopintoupiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuopintoupiaoEntity> wrapper);

   	

}


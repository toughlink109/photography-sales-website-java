package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WorkVoteEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WorkVoteVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WorkVoteView;


/**
 * 作品投票
 *
 * @author 
 * @email 
 */
public interface WorkVoteService extends IService<WorkVoteEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WorkVoteVO> selectListVO(Wrapper<WorkVoteEntity> wrapper);
   	
   	WorkVoteVO selectVO(@Param("ew") Wrapper<WorkVoteEntity> wrapper);
   	
   	List<WorkVoteView> selectListView(Wrapper<WorkVoteEntity> wrapper);
   	
   	WorkVoteView selectView(@Param("ew") Wrapper<WorkVoteEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WorkVoteEntity> wrapper);

   	

}


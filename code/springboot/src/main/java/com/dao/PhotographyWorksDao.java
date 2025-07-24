package com.dao;

import com.entity.PhotographyWorksEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PhotographyWorksVO;
import com.entity.view.PhotographyWorksView;


/**
 * 摄影作品
 * 
 * @author 
 * @email 
 */
public interface PhotographyWorksDao extends BaseMapper<PhotographyWorksEntity> {
	
	List<PhotographyWorksVO> selectListVO(@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);
	
	PhotographyWorksVO selectVO(@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);
	
	List<PhotographyWorksView> selectListView(@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);

	List<PhotographyWorksView> selectListView(Pagination page,@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);

	
	PhotographyWorksView selectView(@Param("ew") Wrapper<PhotographyWorksEntity> wrapper);
	

}

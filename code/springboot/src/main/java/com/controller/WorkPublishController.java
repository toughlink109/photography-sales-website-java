package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WorkPublishEntity;
import com.entity.view.WorkPublishView;

import com.service.WorkPublishService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.FavoritesService;
import com.entity.FavoritesEntity;

/**
 * 作品发布
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/workPublish")
public class WorkPublishController {
    @Autowired
    private WorkPublishService workPublishService;

    @Autowired
    private FavoritesService favoritesService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WorkPublishEntity workPublish,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("ordinaryUser")) {
			workPublish.setAccount((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WorkPublishEntity> ew = new EntityWrapper<WorkPublishEntity>();

		PageUtils page = workPublishService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workPublish), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WorkPublishEntity workPublish, 
		HttpServletRequest request){
        EntityWrapper<WorkPublishEntity> ew = new EntityWrapper<WorkPublishEntity>();

		PageUtils page = workPublishService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workPublish), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WorkPublishEntity workPublish){
       	EntityWrapper<WorkPublishEntity> ew = new EntityWrapper<WorkPublishEntity>();
      	ew.allEq(MPUtil.allEQMapPre( workPublish, "workPublish")); 
        return R.ok().put("data", workPublishService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WorkPublishEntity workPublish){
        EntityWrapper< WorkPublishEntity> ew = new EntityWrapper< WorkPublishEntity>();
 		ew.allEq(MPUtil.allEQMapPre( workPublish, "workPublish")); 
		WorkPublishView workPublishView =  workPublishService.selectView(ew);
		return R.ok("查询作品发布成功").put("data", workPublishView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WorkPublishEntity workPublish = workPublishService.selectById(id);
		workPublish.setClickNum(workPublish.getClickNum()+1);
		workPublish.setLastClickTime(new Date());
		workPublishService.updateById(workPublish);
        workPublish = workPublishService.selectView(new EntityWrapper<WorkPublishEntity>().eq("id", id));
        return R.ok().put("data", workPublish);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WorkPublishEntity workPublish = workPublishService.selectById(id);
		workPublish.setClickNum(workPublish.getClickNum()+1);
		workPublish.setLastClickTime(new Date());
		workPublishService.updateById(workPublish);
        workPublish = workPublishService.selectView(new EntityWrapper<WorkPublishEntity>().eq("id", id));
        return R.ok().put("data", workPublish);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WorkPublishEntity workPublish, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(workPublish);
        workPublishService.insert(workPublish);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody WorkPublishEntity workPublish, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(workPublish);
        workPublishService.insert(workPublish);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WorkPublishEntity workPublish, HttpServletRequest request){
        //ValidatorUtils.validateEntity(workPublish);
        workPublishService.updateById(workPublish);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String isApproved, @RequestParam String approvedComments){
        List<WorkPublishEntity> list = new ArrayList<WorkPublishEntity>();
        for(Long id : ids) {
            WorkPublishEntity workPublish = workPublishService.selectById(id);
            workPublish.setIsApproved(isApproved);
            workPublish.setApprovedComments(approvedComments);
            list.add(workPublish);
        }
        workPublishService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        workPublishService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,WorkPublishEntity workPublish, HttpServletRequest request,String pre){
        EntityWrapper<WorkPublishEntity> ew = new EntityWrapper<WorkPublishEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clickNum");
        params.put("order", "desc");
		PageUtils page = workPublishService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workPublish), params), params));
        return R.ok().put("data", page);
    }










}

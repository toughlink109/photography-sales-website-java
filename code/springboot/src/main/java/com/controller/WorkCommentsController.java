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

import com.entity.WorkCommentsEntity;
import com.entity.view.WorkCommentsView;

import com.service.WorkCommentsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作品发布评论表
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/workComments")
public class WorkCommentsController {
    @Autowired
    private WorkCommentsService workCommentsService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WorkCommentsEntity workComments,
		HttpServletRequest request){
        EntityWrapper<WorkCommentsEntity> ew = new EntityWrapper<WorkCommentsEntity>();

		PageUtils page = workCommentsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workComments), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WorkCommentsEntity workComments, 
		HttpServletRequest request){
        EntityWrapper<WorkCommentsEntity> ew = new EntityWrapper<WorkCommentsEntity>();

		PageUtils page = workCommentsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workComments), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WorkCommentsEntity workComments){
       	EntityWrapper<WorkCommentsEntity> ew = new EntityWrapper<WorkCommentsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( workComments, "workComments")); 
        return R.ok().put("data", workCommentsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WorkCommentsEntity workComments){
        EntityWrapper< WorkCommentsEntity> ew = new EntityWrapper< WorkCommentsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( workComments, "workComments")); 
		WorkCommentsView workCommentsView =  workCommentsService.selectView(ew);
		return R.ok("查询作品发布评论表成功").put("data", workCommentsView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WorkCommentsEntity workComments = workCommentsService.selectById(id);
        return R.ok().put("data", workComments);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WorkCommentsEntity workComments = workCommentsService.selectById(id);
        return R.ok().put("data", workComments);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WorkCommentsEntity workComments, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(workComments);
        workCommentsService.insert(workComments);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WorkCommentsEntity workComments, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(workComments);
        workCommentsService.insert(workComments);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        WorkCommentsEntity workComments = workCommentsService.selectOne(new EntityWrapper<WorkCommentsEntity>().eq("", username));
        return R.ok().put("data", workComments);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody WorkCommentsEntity workComments, HttpServletRequest request){
        //ValidatorUtils.validateEntity(workComments);
        workCommentsService.updateById(workComments);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        workCommentsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,WorkCommentsEntity workComments, HttpServletRequest request,String pre){
        EntityWrapper<WorkCommentsEntity> ew = new EntityWrapper<WorkCommentsEntity>();
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
		params.put("sort", "lastClickTime");
        params.put("order", "desc");
		PageUtils page = workCommentsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, workComments), params), params));
        return R.ok().put("data", page);
    }










}

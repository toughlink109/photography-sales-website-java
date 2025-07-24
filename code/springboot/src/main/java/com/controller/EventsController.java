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

import com.entity.EventsEntity;
import com.entity.view.EventsView;

import com.service.EventsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 摄影活动
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventsService eventsService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,EventsEntity events,
		HttpServletRequest request){
        EntityWrapper<EventsEntity> ew = new EntityWrapper<EventsEntity>();

		PageUtils page = eventsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, events), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,EventsEntity events, 
		HttpServletRequest request){
        EntityWrapper<EventsEntity> ew = new EntityWrapper<EventsEntity>();

		PageUtils page = eventsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, events), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( EventsEntity events){
       	EntityWrapper<EventsEntity> ew = new EntityWrapper<EventsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( events, "events")); 
        return R.ok().put("data", eventsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(EventsEntity events){
        EntityWrapper< EventsEntity> ew = new EntityWrapper< EventsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( events, "events")); 
		EventsView eventsView =  eventsService.selectView(ew);
		return R.ok("查询摄影活动成功").put("data", eventsView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        EventsEntity events = eventsService.selectById(id);
        return R.ok().put("data", events);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        EventsEntity events = eventsService.selectById(id);
        return R.ok().put("data", events);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EventsEntity events, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(events);
        eventsService.insert(events);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody EventsEntity events, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(events);
        eventsService.insert(events);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody EventsEntity events, HttpServletRequest request){
        //ValidatorUtils.validateEntity(events);
        eventsService.updateById(events);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        eventsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.SheyinghuodongEntity;
import com.entity.view.SheyinghuodongView;

import com.service.SheyinghuodongService;
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
 * @date 2030-04-26 20:41:37
 */
@RestController
@RequestMapping("/sheyinghuodong")
public class SheyinghuodongController {
    @Autowired
    private SheyinghuodongService sheyinghuodongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheyinghuodongEntity sheyinghuodong,
		HttpServletRequest request){
        EntityWrapper<SheyinghuodongEntity> ew = new EntityWrapper<SheyinghuodongEntity>();

		PageUtils page = sheyinghuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyinghuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheyinghuodongEntity sheyinghuodong, 
		HttpServletRequest request){
        EntityWrapper<SheyinghuodongEntity> ew = new EntityWrapper<SheyinghuodongEntity>();

		PageUtils page = sheyinghuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyinghuodong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheyinghuodongEntity sheyinghuodong){
       	EntityWrapper<SheyinghuodongEntity> ew = new EntityWrapper<SheyinghuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheyinghuodong, "sheyinghuodong")); 
        return R.ok().put("data", sheyinghuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheyinghuodongEntity sheyinghuodong){
        EntityWrapper< SheyinghuodongEntity> ew = new EntityWrapper< SheyinghuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheyinghuodong, "sheyinghuodong")); 
		SheyinghuodongView sheyinghuodongView =  sheyinghuodongService.selectView(ew);
		return R.ok("查询摄影活动成功").put("data", sheyinghuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SheyinghuodongEntity sheyinghuodong = sheyinghuodongService.selectById(id);
        return R.ok().put("data", sheyinghuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SheyinghuodongEntity sheyinghuodong = sheyinghuodongService.selectById(id);
        return R.ok().put("data", sheyinghuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheyinghuodongEntity sheyinghuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyinghuodong);
        sheyinghuodongService.insert(sheyinghuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheyinghuodongEntity sheyinghuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyinghuodong);
        sheyinghuodongService.insert(sheyinghuodong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SheyinghuodongEntity sheyinghuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyinghuodong);
        sheyinghuodongService.updateById(sheyinghuodong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheyinghuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

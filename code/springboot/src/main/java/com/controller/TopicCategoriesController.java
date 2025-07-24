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

import com.entity.TopicCategoriesEntity;
import com.entity.view.TopicCategoriesView;

import com.service.TopicCategoriesService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 话题分类
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/topicCategories")
public class TopicCategoriesController {
    @Autowired
    private TopicCategoriesService topicCategoriesService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TopicCategoriesEntity topicCategories,
		HttpServletRequest request){
        EntityWrapper<TopicCategoriesEntity> ew = new EntityWrapper<TopicCategoriesEntity>();

		PageUtils page = topicCategoriesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, topicCategories), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TopicCategoriesEntity topicCategories, 
		HttpServletRequest request){
        EntityWrapper<TopicCategoriesEntity> ew = new EntityWrapper<TopicCategoriesEntity>();

		PageUtils page = topicCategoriesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, topicCategories), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TopicCategoriesEntity topicCategories){
       	EntityWrapper<TopicCategoriesEntity> ew = new EntityWrapper<TopicCategoriesEntity>();
      	ew.allEq(MPUtil.allEQMapPre( topicCategories, "topicCategories")); 
        return R.ok().put("data", topicCategoriesService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TopicCategoriesEntity topicCategories){
        EntityWrapper< TopicCategoriesEntity> ew = new EntityWrapper< TopicCategoriesEntity>();
 		ew.allEq(MPUtil.allEQMapPre( topicCategories, "topicCategories")); 
		TopicCategoriesView topicCategoriesView =  topicCategoriesService.selectView(ew);
		return R.ok("查询话题分类成功").put("data", topicCategoriesView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TopicCategoriesEntity topicCategories = topicCategoriesService.selectById(id);
        return R.ok().put("data", topicCategories);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TopicCategoriesEntity topicCategories = topicCategoriesService.selectById(id);
        return R.ok().put("data", topicCategories);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TopicCategoriesEntity topicCategories, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(topicCategories);
        topicCategoriesService.insert(topicCategories);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TopicCategoriesEntity topicCategories, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(topicCategories);
        topicCategoriesService.insert(topicCategories);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TopicCategoriesEntity topicCategories, HttpServletRequest request){
        //ValidatorUtils.validateEntity(topicCategories);
        topicCategoriesService.updateById(topicCategories);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        topicCategoriesService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

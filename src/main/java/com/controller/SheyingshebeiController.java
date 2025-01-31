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

import com.entity.SheyingshebeiEntity;
import com.entity.view.SheyingshebeiView;

import com.service.SheyingshebeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 摄影设备
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@RestController
@RequestMapping("/sheyingshebei")
public class SheyingshebeiController {
    @Autowired
    private SheyingshebeiService sheyingshebeiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheyingshebeiEntity sheyingshebei,
		HttpServletRequest request){
        EntityWrapper<SheyingshebeiEntity> ew = new EntityWrapper<SheyingshebeiEntity>();

		PageUtils page = sheyingshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingshebei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheyingshebeiEntity sheyingshebei, 
		HttpServletRequest request){
        EntityWrapper<SheyingshebeiEntity> ew = new EntityWrapper<SheyingshebeiEntity>();

		PageUtils page = sheyingshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingshebei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheyingshebeiEntity sheyingshebei){
       	EntityWrapper<SheyingshebeiEntity> ew = new EntityWrapper<SheyingshebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheyingshebei, "sheyingshebei")); 
        return R.ok().put("data", sheyingshebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheyingshebeiEntity sheyingshebei){
        EntityWrapper< SheyingshebeiEntity> ew = new EntityWrapper< SheyingshebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheyingshebei, "sheyingshebei")); 
		SheyingshebeiView sheyingshebeiView =  sheyingshebeiService.selectView(ew);
		return R.ok("查询摄影设备成功").put("data", sheyingshebeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SheyingshebeiEntity sheyingshebei = sheyingshebeiService.selectById(id);
		sheyingshebei.setClicktime(new Date());
		sheyingshebeiService.updateById(sheyingshebei);
        sheyingshebei = sheyingshebeiService.selectView(new EntityWrapper<SheyingshebeiEntity>().eq("id", id));
        return R.ok().put("data", sheyingshebei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SheyingshebeiEntity sheyingshebei = sheyingshebeiService.selectById(id);
		sheyingshebei.setClicktime(new Date());
		sheyingshebeiService.updateById(sheyingshebei);
        sheyingshebei = sheyingshebeiService.selectView(new EntityWrapper<SheyingshebeiEntity>().eq("id", id));
        return R.ok().put("data", sheyingshebei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheyingshebeiEntity sheyingshebei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyingshebei);
        sheyingshebeiService.insert(sheyingshebei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheyingshebeiEntity sheyingshebei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyingshebei);
        sheyingshebeiService.insert(sheyingshebei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SheyingshebeiEntity sheyingshebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyingshebei);
        sheyingshebeiService.updateById(sheyingshebei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheyingshebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SheyingshebeiEntity sheyingshebei, HttpServletRequest request,String pre){
        EntityWrapper<SheyingshebeiEntity> ew = new EntityWrapper<SheyingshebeiEntity>();
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
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = sheyingshebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingshebei), params), params));
        return R.ok().put("data", page);
    }










}

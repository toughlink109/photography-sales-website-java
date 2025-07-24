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

import com.entity.SystemIntroEntity;
import com.entity.view.SystemIntroView;

import com.service.SystemIntroService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 系统简介
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/systemIntro")
public class SystemIntroController {
    @Autowired
    private SystemIntroService systemIntroService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SystemIntroEntity systemIntro,
		HttpServletRequest request){
        EntityWrapper<SystemIntroEntity> ew = new EntityWrapper<SystemIntroEntity>();

		PageUtils page = systemIntroService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, systemIntro), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SystemIntroEntity systemIntro, 
		HttpServletRequest request){
        EntityWrapper<SystemIntroEntity> ew = new EntityWrapper<SystemIntroEntity>();

		PageUtils page = systemIntroService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, systemIntro), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SystemIntroEntity systemIntro){
       	EntityWrapper<SystemIntroEntity> ew = new EntityWrapper<SystemIntroEntity>();
      	ew.allEq(MPUtil.allEQMapPre( systemIntro, "systemIntro")); 
        return R.ok().put("data", systemIntroService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SystemIntroEntity systemIntro){
        EntityWrapper< SystemIntroEntity> ew = new EntityWrapper< SystemIntroEntity>();
 		ew.allEq(MPUtil.allEQMapPre( systemIntro, "systemIntro")); 
		SystemIntroView systemIntroView =  systemIntroService.selectView(ew);
		return R.ok("查询系统简介成功").put("data", systemIntroView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SystemIntroEntity systemIntro = systemIntroService.selectById(id);
        return R.ok().put("data", systemIntro);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SystemIntroEntity systemIntro = systemIntroService.selectById(id);
        return R.ok().put("data", systemIntro);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SystemIntroEntity systemIntro, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(systemIntro);
        systemIntroService.insert(systemIntro);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SystemIntroEntity systemIntro, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(systemIntro);
        systemIntroService.insert(systemIntro);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        SystemIntroEntity systemIntro = systemIntroService.selectOne(new EntityWrapper<SystemIntroEntity>().eq("", username));
        return R.ok().put("data", systemIntro);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody SystemIntroEntity systemIntro, HttpServletRequest request){
        //ValidatorUtils.validateEntity(systemIntro);
        systemIntroService.updateById(systemIntro);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        systemIntroService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SystemIntroEntity systemIntro, HttpServletRequest request,String pre){
        EntityWrapper<SystemIntroEntity> ew = new EntityWrapper<SystemIntroEntity>();
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
		PageUtils page = systemIntroService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, systemIntro), params), params));
        return R.ok().put("data", page);
    }










}

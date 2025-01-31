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

import com.entity.ZuopinfenleiEntity;
import com.entity.view.ZuopinfenleiView;

import com.service.ZuopinfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作品分类
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@RestController
@RequestMapping("/zuopinfenlei")
public class ZuopinfenleiController {
    @Autowired
    private ZuopinfenleiService zuopinfenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuopinfenleiEntity zuopinfenlei,
		HttpServletRequest request){
        EntityWrapper<ZuopinfenleiEntity> ew = new EntityWrapper<ZuopinfenleiEntity>();

		PageUtils page = zuopinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuopinfenleiEntity zuopinfenlei, 
		HttpServletRequest request){
        EntityWrapper<ZuopinfenleiEntity> ew = new EntityWrapper<ZuopinfenleiEntity>();

		PageUtils page = zuopinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinfenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuopinfenleiEntity zuopinfenlei){
       	EntityWrapper<ZuopinfenleiEntity> ew = new EntityWrapper<ZuopinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuopinfenlei, "zuopinfenlei")); 
        return R.ok().put("data", zuopinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuopinfenleiEntity zuopinfenlei){
        EntityWrapper< ZuopinfenleiEntity> ew = new EntityWrapper< ZuopinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuopinfenlei, "zuopinfenlei")); 
		ZuopinfenleiView zuopinfenleiView =  zuopinfenleiService.selectView(ew);
		return R.ok("查询作品分类成功").put("data", zuopinfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuopinfenleiEntity zuopinfenlei = zuopinfenleiService.selectById(id);
        return R.ok().put("data", zuopinfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuopinfenleiEntity zuopinfenlei = zuopinfenleiService.selectById(id);
        return R.ok().put("data", zuopinfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuopinfenleiEntity zuopinfenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuopinfenlei);
        zuopinfenleiService.insert(zuopinfenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuopinfenleiEntity zuopinfenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuopinfenlei);
        zuopinfenleiService.insert(zuopinfenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuopinfenleiEntity zuopinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuopinfenlei);
        zuopinfenleiService.updateById(zuopinfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuopinfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

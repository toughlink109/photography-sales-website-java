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

import com.entity.SheyingshebeizuyongEntity;
import com.entity.view.SheyingshebeizuyongView;

import com.service.SheyingshebeizuyongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 摄影设备租用
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@RestController
@RequestMapping("/sheyingshebeizuyong")
public class SheyingshebeizuyongController {
    @Autowired
    private SheyingshebeizuyongService sheyingshebeizuyongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheyingshebeizuyongEntity sheyingshebeizuyong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			sheyingshebeizuyong.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SheyingshebeizuyongEntity> ew = new EntityWrapper<SheyingshebeizuyongEntity>();

		PageUtils page = sheyingshebeizuyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingshebeizuyong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheyingshebeizuyongEntity sheyingshebeizuyong, 
		HttpServletRequest request){
        EntityWrapper<SheyingshebeizuyongEntity> ew = new EntityWrapper<SheyingshebeizuyongEntity>();

		PageUtils page = sheyingshebeizuyongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingshebeizuyong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheyingshebeizuyongEntity sheyingshebeizuyong){
       	EntityWrapper<SheyingshebeizuyongEntity> ew = new EntityWrapper<SheyingshebeizuyongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheyingshebeizuyong, "sheyingshebeizuyong")); 
        return R.ok().put("data", sheyingshebeizuyongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheyingshebeizuyongEntity sheyingshebeizuyong){
        EntityWrapper< SheyingshebeizuyongEntity> ew = new EntityWrapper< SheyingshebeizuyongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheyingshebeizuyong, "sheyingshebeizuyong")); 
		SheyingshebeizuyongView sheyingshebeizuyongView =  sheyingshebeizuyongService.selectView(ew);
		return R.ok("查询摄影设备租用成功").put("data", sheyingshebeizuyongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SheyingshebeizuyongEntity sheyingshebeizuyong = sheyingshebeizuyongService.selectById(id);
        return R.ok().put("data", sheyingshebeizuyong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SheyingshebeizuyongEntity sheyingshebeizuyong = sheyingshebeizuyongService.selectById(id);
        return R.ok().put("data", sheyingshebeizuyong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheyingshebeizuyongEntity sheyingshebeizuyong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyingshebeizuyong);
        sheyingshebeizuyongService.insert(sheyingshebeizuyong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheyingshebeizuyongEntity sheyingshebeizuyong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyingshebeizuyong);
        sheyingshebeizuyongService.insert(sheyingshebeizuyong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SheyingshebeizuyongEntity sheyingshebeizuyong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyingshebeizuyong);
        sheyingshebeizuyongService.updateById(sheyingshebeizuyong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<SheyingshebeizuyongEntity> list = new ArrayList<SheyingshebeizuyongEntity>();
        for(Long id : ids) {
            SheyingshebeizuyongEntity sheyingshebeizuyong = sheyingshebeizuyongService.selectById(id);
            sheyingshebeizuyong.setSfsh(sfsh);
            sheyingshebeizuyong.setShhf(shhf);
            list.add(sheyingshebeizuyong);
        }
        sheyingshebeizuyongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheyingshebeizuyongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

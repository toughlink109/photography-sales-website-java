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

import com.entity.EquipmentReturnsEntity;
import com.entity.view.EquipmentReturnsView;

import com.service.EquipmentReturnsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备归还
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/equipmentReturns")
public class EquipmentReturnsController {
    @Autowired
    private EquipmentReturnsService equipmentReturnsService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,EquipmentReturnsEntity equipmentReturns,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("ordinaryUser")) {
			equipmentReturns.setAccount((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<EquipmentReturnsEntity> ew = new EntityWrapper<EquipmentReturnsEntity>();

		PageUtils page = equipmentReturnsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, equipmentReturns), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,EquipmentReturnsEntity equipmentReturns, 
		HttpServletRequest request){
        EntityWrapper<EquipmentReturnsEntity> ew = new EntityWrapper<EquipmentReturnsEntity>();

		PageUtils page = equipmentReturnsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, equipmentReturns), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( EquipmentReturnsEntity equipmentReturns){
       	EntityWrapper<EquipmentReturnsEntity> ew = new EntityWrapper<EquipmentReturnsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( equipmentReturns, "equipmentReturns")); 
        return R.ok().put("data", equipmentReturnsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(EquipmentReturnsEntity equipmentReturns){
        EntityWrapper< EquipmentReturnsEntity> ew = new EntityWrapper< EquipmentReturnsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( equipmentReturns, "equipmentReturns")); 
		EquipmentReturnsView equipmentReturnsView =  equipmentReturnsService.selectView(ew);
		return R.ok("查询设备归还成功").put("data", equipmentReturnsView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        EquipmentReturnsEntity equipmentReturns = equipmentReturnsService.selectById(id);
        return R.ok().put("data", equipmentReturns);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        EquipmentReturnsEntity equipmentReturns = equipmentReturnsService.selectById(id);
        return R.ok().put("data", equipmentReturns);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EquipmentReturnsEntity equipmentReturns, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(equipmentReturns);
        equipmentReturnsService.insert(equipmentReturns);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody EquipmentReturnsEntity equipmentReturns, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(equipmentReturns);
        equipmentReturnsService.insert(equipmentReturns);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody EquipmentReturnsEntity equipmentReturns, HttpServletRequest request){
        //ValidatorUtils.validateEntity(equipmentReturns);
        equipmentReturnsService.updateById(equipmentReturns);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        equipmentReturnsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

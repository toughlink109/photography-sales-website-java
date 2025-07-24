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

import com.entity.PhotographyEquipmentsEntity;
import com.entity.view.PhotographyEquipmentsView;

import com.service.PhotographyEquipmentsService;
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
 * 摄影设备
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/photographyEquipments")
public class PhotographyEquipmentsController {
    @Autowired
    private PhotographyEquipmentsService photographyEquipmentsService;

    @Autowired
    private FavoritesService favoritesService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PhotographyEquipmentsEntity photographyEquipments,
		HttpServletRequest request){
        EntityWrapper<PhotographyEquipmentsEntity> ew = new EntityWrapper<PhotographyEquipmentsEntity>();

		PageUtils page = photographyEquipmentsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyEquipments), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PhotographyEquipmentsEntity photographyEquipments, 
		HttpServletRequest request){
        EntityWrapper<PhotographyEquipmentsEntity> ew = new EntityWrapper<PhotographyEquipmentsEntity>();

		PageUtils page = photographyEquipmentsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyEquipments), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PhotographyEquipmentsEntity photographyEquipments){
       	EntityWrapper<PhotographyEquipmentsEntity> ew = new EntityWrapper<PhotographyEquipmentsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( photographyEquipments, "photographyEquipments")); 
        return R.ok().put("data", photographyEquipmentsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PhotographyEquipmentsEntity photographyEquipments){
        EntityWrapper< PhotographyEquipmentsEntity> ew = new EntityWrapper< PhotographyEquipmentsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( photographyEquipments, "photographyEquipments")); 
		PhotographyEquipmentsView photographyEquipmentsView =  photographyEquipmentsService.selectView(ew);
		return R.ok("查询摄影设备成功").put("data", photographyEquipmentsView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PhotographyEquipmentsEntity photographyEquipments = photographyEquipmentsService.selectById(id);
		photographyEquipments.setLastClickTime(new Date());
		photographyEquipmentsService.updateById(photographyEquipments);
        photographyEquipments = photographyEquipmentsService.selectView(new EntityWrapper<PhotographyEquipmentsEntity>().eq("id", id));
        return R.ok().put("data", photographyEquipments);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PhotographyEquipmentsEntity photographyEquipments = photographyEquipmentsService.selectById(id);
		photographyEquipments.setLastClickTime(new Date());
		photographyEquipmentsService.updateById(photographyEquipments);
        photographyEquipments = photographyEquipmentsService.selectView(new EntityWrapper<PhotographyEquipmentsEntity>().eq("id", id));
        return R.ok().put("data", photographyEquipments);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PhotographyEquipmentsEntity photographyEquipments, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(photographyEquipments);
        photographyEquipmentsService.insert(photographyEquipments);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PhotographyEquipmentsEntity photographyEquipments, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(photographyEquipments);
        photographyEquipmentsService.insert(photographyEquipments);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PhotographyEquipmentsEntity photographyEquipments, HttpServletRequest request){
        //ValidatorUtils.validateEntity(photographyEquipments);
        photographyEquipmentsService.updateById(photographyEquipments);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        photographyEquipmentsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,PhotographyEquipmentsEntity photographyEquipments, HttpServletRequest request,String pre){
        EntityWrapper<PhotographyEquipmentsEntity> ew = new EntityWrapper<PhotographyEquipmentsEntity>();
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
		PageUtils page = photographyEquipmentsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyEquipments), params), params));
        return R.ok().put("data", page);
    }










}

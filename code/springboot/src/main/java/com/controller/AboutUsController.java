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

import com.entity.AboutUsEntity;
import com.entity.view.AboutUsView;

import com.service.AboutUsService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 关于我们
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/aboutUs")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AboutUsEntity aboutUs,
		HttpServletRequest request){
        EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();

		PageUtils page = aboutUsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutUs), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AboutUsEntity aboutUs, 
		HttpServletRequest request){
        EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();

		PageUtils page = aboutUsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutUs), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AboutUsEntity aboutUs){
       	EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( aboutUs, "aboutUs")); 
        return R.ok().put("data", aboutUsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AboutUsEntity aboutUs){
        EntityWrapper< AboutUsEntity> ew = new EntityWrapper< AboutUsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( aboutUs, "aboutUs")); 
		AboutUsView aboutUsView =  aboutUsService.selectView(ew);
		return R.ok("查询关于我们成功").put("data", aboutUsView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AboutUsEntity aboutUs = aboutUsService.selectById(id);
        return R.ok().put("data", aboutUs);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AboutUsEntity aboutUs = aboutUsService.selectById(id);
        return R.ok().put("data", aboutUs);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AboutUsEntity aboutUs, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(aboutUs);
        aboutUsService.insert(aboutUs);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AboutUsEntity aboutUs, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(aboutUs);
        aboutUsService.insert(aboutUs);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        AboutUsEntity aboutUs = aboutUsService.selectOne(new EntityWrapper<AboutUsEntity>().eq("", username));
        return R.ok().put("data", aboutUs);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody AboutUsEntity aboutUs, HttpServletRequest request){
        //ValidatorUtils.validateEntity(aboutUs);
        aboutUsService.updateById(aboutUs);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        aboutUsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,AboutUsEntity aboutUs, HttpServletRequest request,String pre){
        EntityWrapper<AboutUsEntity> ew = new EntityWrapper<AboutUsEntity>();
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
		PageUtils page = aboutUsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutUs), params), params));
        return R.ok().put("data", page);
    }










}

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

import com.entity.ActivityRegistrationEntity;
import com.entity.view.ActivityRegistrationView;

import com.service.ActivityRegistrationService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 报名活动
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/activityRegistration")
public class ActivityRegistrationController {
    @Autowired
    private ActivityRegistrationService activityRegistrationService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ActivityRegistrationEntity activityRegistration,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("ordinaryUser")) {
			activityRegistration.setAccount((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();

		PageUtils page = activityRegistrationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityRegistration), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ActivityRegistrationEntity activityRegistration, 
		HttpServletRequest request){
        EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();

		PageUtils page = activityRegistrationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityRegistration), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ActivityRegistrationEntity activityRegistration){
       	EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( activityRegistration, "activityRegistration")); 
        return R.ok().put("data", activityRegistrationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ActivityRegistrationEntity activityRegistration){
        EntityWrapper< ActivityRegistrationEntity> ew = new EntityWrapper< ActivityRegistrationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( activityRegistration, "activityRegistration")); 
		ActivityRegistrationView activityRegistrationView =  activityRegistrationService.selectView(ew);
		return R.ok("查询报名活动成功").put("data", activityRegistrationView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ActivityRegistrationEntity activityRegistration = activityRegistrationService.selectById(id);
        return R.ok().put("data", activityRegistration);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ActivityRegistrationEntity activityRegistration = activityRegistrationService.selectById(id);
        return R.ok().put("data", activityRegistration);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ActivityRegistrationEntity activityRegistration, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(activityRegistration);
        activityRegistrationService.insert(activityRegistration);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ActivityRegistrationEntity activityRegistration, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(activityRegistration);
        activityRegistrationService.insert(activityRegistration);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ActivityRegistrationEntity activityRegistration, HttpServletRequest request){
        //ValidatorUtils.validateEntity(activityRegistration);
        activityRegistrationService.updateById(activityRegistration);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String isApproved, @RequestParam String approvedComments){
        List<ActivityRegistrationEntity> list = new ArrayList<ActivityRegistrationEntity>();
        for(Long id : ids) {
            ActivityRegistrationEntity activityRegistration = activityRegistrationService.selectById(id);
            activityRegistration.setIsApproved(isApproved);
            activityRegistration.setApprovedComments(approvedComments);
            list.add(activityRegistration);
        }
        activityRegistrationService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        activityRegistrationService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.ZuopintoupiaoEntity;
import com.entity.view.ZuopintoupiaoView;

import com.service.ZuopintoupiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作品投票
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-26 20:41:38
 */
@RestController
@RequestMapping("/zuopintoupiao")
public class ZuopintoupiaoController {
    @Autowired
    private ZuopintoupiaoService zuopintoupiaoService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuopintoupiaoEntity zuopintoupiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zuopintoupiao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuopintoupiaoEntity> ew = new EntityWrapper<ZuopintoupiaoEntity>();

		PageUtils page = zuopintoupiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopintoupiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuopintoupiaoEntity zuopintoupiao, 
		HttpServletRequest request){
        EntityWrapper<ZuopintoupiaoEntity> ew = new EntityWrapper<ZuopintoupiaoEntity>();

		PageUtils page = zuopintoupiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopintoupiao), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuopintoupiaoEntity zuopintoupiao){
       	EntityWrapper<ZuopintoupiaoEntity> ew = new EntityWrapper<ZuopintoupiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuopintoupiao, "zuopintoupiao")); 
        return R.ok().put("data", zuopintoupiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuopintoupiaoEntity zuopintoupiao){
        EntityWrapper< ZuopintoupiaoEntity> ew = new EntityWrapper< ZuopintoupiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuopintoupiao, "zuopintoupiao")); 
		ZuopintoupiaoView zuopintoupiaoView =  zuopintoupiaoService.selectView(ew);
		return R.ok("查询作品投票成功").put("data", zuopintoupiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuopintoupiaoEntity zuopintoupiao = zuopintoupiaoService.selectById(id);
        return R.ok().put("data", zuopintoupiao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuopintoupiaoEntity zuopintoupiao = zuopintoupiaoService.selectById(id);
        return R.ok().put("data", zuopintoupiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuopintoupiaoEntity zuopintoupiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuopintoupiao);
        zuopintoupiaoService.insert(zuopintoupiao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuopintoupiaoEntity zuopintoupiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuopintoupiao);
        zuopintoupiaoService.insert(zuopintoupiao);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuopintoupiaoEntity zuopintoupiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuopintoupiao);
        zuopintoupiaoService.updateById(zuopintoupiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuopintoupiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

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

import com.entity.ZuopinfabuEntity;
import com.entity.view.ZuopinfabuView;

import com.service.ZuopinfabuService;
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
 * 作品发布
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@RestController
@RequestMapping("/zuopinfabu")
public class ZuopinfabuController {
    @Autowired
    private ZuopinfabuService zuopinfabuService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuopinfabuEntity zuopinfabu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zuopinfabu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuopinfabuEntity> ew = new EntityWrapper<ZuopinfabuEntity>();

		PageUtils page = zuopinfabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinfabu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuopinfabuEntity zuopinfabu, 
		HttpServletRequest request){
        EntityWrapper<ZuopinfabuEntity> ew = new EntityWrapper<ZuopinfabuEntity>();

		PageUtils page = zuopinfabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinfabu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuopinfabuEntity zuopinfabu){
       	EntityWrapper<ZuopinfabuEntity> ew = new EntityWrapper<ZuopinfabuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuopinfabu, "zuopinfabu")); 
        return R.ok().put("data", zuopinfabuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuopinfabuEntity zuopinfabu){
        EntityWrapper< ZuopinfabuEntity> ew = new EntityWrapper< ZuopinfabuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuopinfabu, "zuopinfabu")); 
		ZuopinfabuView zuopinfabuView =  zuopinfabuService.selectView(ew);
		return R.ok("查询作品发布成功").put("data", zuopinfabuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuopinfabuEntity zuopinfabu = zuopinfabuService.selectById(id);
		zuopinfabu.setClicknum(zuopinfabu.getClicknum()+1);
		zuopinfabu.setClicktime(new Date());
		zuopinfabuService.updateById(zuopinfabu);
        zuopinfabu = zuopinfabuService.selectView(new EntityWrapper<ZuopinfabuEntity>().eq("id", id));
        return R.ok().put("data", zuopinfabu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuopinfabuEntity zuopinfabu = zuopinfabuService.selectById(id);
		zuopinfabu.setClicknum(zuopinfabu.getClicknum()+1);
		zuopinfabu.setClicktime(new Date());
		zuopinfabuService.updateById(zuopinfabu);
        zuopinfabu = zuopinfabuService.selectView(new EntityWrapper<ZuopinfabuEntity>().eq("id", id));
        return R.ok().put("data", zuopinfabu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuopinfabuEntity zuopinfabu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuopinfabu);
        zuopinfabuService.insert(zuopinfabu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZuopinfabuEntity zuopinfabu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuopinfabu);
        zuopinfabuService.insert(zuopinfabu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuopinfabuEntity zuopinfabu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuopinfabu);
        zuopinfabuService.updateById(zuopinfabu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZuopinfabuEntity> list = new ArrayList<ZuopinfabuEntity>();
        for(Long id : ids) {
            ZuopinfabuEntity zuopinfabu = zuopinfabuService.selectById(id);
            zuopinfabu.setSfsh(sfsh);
            zuopinfabu.setShhf(shhf);
            list.add(zuopinfabu);
        }
        zuopinfabuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuopinfabuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZuopinfabuEntity zuopinfabu, HttpServletRequest request,String pre){
        EntityWrapper<ZuopinfabuEntity> ew = new EntityWrapper<ZuopinfabuEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = zuopinfabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinfabu), params), params));
        return R.ok().put("data", page);
    }










}

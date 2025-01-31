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
import com.entity.OrdersEntity;
import com.service.OrdersService;
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.SheyingzuopinEntity;
import com.entity.view.SheyingzuopinView;

import com.service.SheyingzuopinService;
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
 * 摄影作品
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-26 20:41:37
 */
@RestController
@RequestMapping("/sheyingzuopin")
public class SheyingzuopinController {
    @Autowired
    private SheyingzuopinService sheyingzuopinService;

    @Autowired
    private StoreupService storeupService;

    @Autowired
    private OrdersService ordersService;


    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheyingzuopinEntity sheyingzuopin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<SheyingzuopinEntity> ew = new EntityWrapper<SheyingzuopinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = sheyingzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingzuopin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheyingzuopinEntity sheyingzuopin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<SheyingzuopinEntity> ew = new EntityWrapper<SheyingzuopinEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = sheyingzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingzuopin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheyingzuopinEntity sheyingzuopin){
       	EntityWrapper<SheyingzuopinEntity> ew = new EntityWrapper<SheyingzuopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheyingzuopin, "sheyingzuopin")); 
        return R.ok().put("data", sheyingzuopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheyingzuopinEntity sheyingzuopin){
        EntityWrapper< SheyingzuopinEntity> ew = new EntityWrapper< SheyingzuopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheyingzuopin, "sheyingzuopin")); 
		SheyingzuopinView sheyingzuopinView =  sheyingzuopinService.selectView(ew);
		return R.ok("查询摄影作品成功").put("data", sheyingzuopinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SheyingzuopinEntity sheyingzuopin = sheyingzuopinService.selectById(id);
		sheyingzuopin.setClicknum(sheyingzuopin.getClicknum()+1);
		sheyingzuopinService.updateById(sheyingzuopin);
        sheyingzuopin = sheyingzuopinService.selectView(new EntityWrapper<SheyingzuopinEntity>().eq("id", id));
        return R.ok().put("data", sheyingzuopin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SheyingzuopinEntity sheyingzuopin = sheyingzuopinService.selectById(id);
		sheyingzuopin.setClicknum(sheyingzuopin.getClicknum()+1);
		sheyingzuopinService.updateById(sheyingzuopin);
        sheyingzuopin = sheyingzuopinService.selectView(new EntityWrapper<SheyingzuopinEntity>().eq("id", id));
        return R.ok().put("data", sheyingzuopin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        SheyingzuopinEntity sheyingzuopin = sheyingzuopinService.selectById(id);
        if(type.equals("1")) {
        	sheyingzuopin.setThumbsupnum(sheyingzuopin.getThumbsupnum()+1);
        } else {
        	sheyingzuopin.setCrazilynum(sheyingzuopin.getCrazilynum()+1);
        }
        sheyingzuopinService.updateById(sheyingzuopin);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheyingzuopinEntity sheyingzuopin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyingzuopin);
        sheyingzuopinService.insert(sheyingzuopin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheyingzuopinEntity sheyingzuopin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(sheyingzuopin);
        sheyingzuopinService.insert(sheyingzuopin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SheyingzuopinEntity sheyingzuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheyingzuopin);
        sheyingzuopinService.updateById(sheyingzuopin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheyingzuopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SheyingzuopinEntity sheyingzuopin, HttpServletRequest request,String pre){
        EntityWrapper<SheyingzuopinEntity> ew = new EntityWrapper<SheyingzuopinEntity>();
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
		PageUtils page = sheyingzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheyingzuopin), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,SheyingzuopinEntity sheyingzuopin, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>());
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(orders!=null && orders.size()>0) {
            for(OrdersEntity o : orders) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(o.getUserid().toString())) {
                    userRatings = ratings.get(o.getUserid().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(o.getUserid().toString(), userRatings);
                }
                if(userRatings.containsKey(o.getGoodid().toString())) {
                    userRatings.put(o.getGoodid().toString(), userRatings.get(o.getGoodid().toString())+1.0);
                } else {
                    userRatings.put(o.getGoodid().toString(), 1.0);
                }

            }
        }
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering(ratings);

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(targetUser, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<SheyingzuopinEntity> ew = new EntityWrapper<SheyingzuopinEntity>();
        ew.in("id", recommendations);
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+String.join(",", recommendations)+")");
        }

        PageUtils page = sheyingzuopinService.queryPage(params, ew);
        List<SheyingzuopinEntity> pageList = (List<SheyingzuopinEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<SheyingzuopinEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(sheyingzuopinService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }








}

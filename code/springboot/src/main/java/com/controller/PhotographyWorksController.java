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

import com.entity.PhotographyWorksEntity;
import com.entity.view.PhotographyWorksView;

import com.service.PhotographyWorksService;
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
 * 摄影作品
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/photographyWorks")
public class PhotographyWorksController {
    @Autowired
    private PhotographyWorksService photographyWorksService;

    @Autowired
    private FavoritesService favoritesService;

    @Autowired
    private OrdersService ordersService;


    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PhotographyWorksEntity photographyWorks,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<PhotographyWorksEntity> ew = new EntityWrapper<PhotographyWorksEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = photographyWorksService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyWorks), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PhotographyWorksEntity photographyWorks, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        EntityWrapper<PhotographyWorksEntity> ew = new EntityWrapper<PhotographyWorksEntity>();
                if(pricestart!=null) ew.ge("price", pricestart);
                if(priceend!=null) ew.le("price", priceend);

		PageUtils page = photographyWorksService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyWorks), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PhotographyWorksEntity photographyWorks){
       	EntityWrapper<PhotographyWorksEntity> ew = new EntityWrapper<PhotographyWorksEntity>();
      	ew.allEq(MPUtil.allEQMapPre( photographyWorks, "photographyWorks")); 
        return R.ok().put("data", photographyWorksService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PhotographyWorksEntity photographyWorks){
        EntityWrapper< PhotographyWorksEntity> ew = new EntityWrapper< PhotographyWorksEntity>();
 		ew.allEq(MPUtil.allEQMapPre( photographyWorks, "photographyWorks")); 
		PhotographyWorksView photographyWorksView =  photographyWorksService.selectView(ew);
		return R.ok("查询摄影作品成功").put("data", photographyWorksView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PhotographyWorksEntity photographyWorks = photographyWorksService.selectById(id);
		photographyWorks.setClickNum(photographyWorks.getClickNum()+1);
		photographyWorksService.updateById(photographyWorks);
        photographyWorks = photographyWorksService.selectView(new EntityWrapper<PhotographyWorksEntity>().eq("id", id));
        return R.ok().put("data", photographyWorks);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PhotographyWorksEntity photographyWorks = photographyWorksService.selectById(id);
		photographyWorks.setClickNum(photographyWorks.getClickNum()+1);
		photographyWorksService.updateById(photographyWorks);
        photographyWorks = photographyWorksService.selectView(new EntityWrapper<PhotographyWorksEntity>().eq("id", id));
        return R.ok().put("data", photographyWorks);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        PhotographyWorksEntity photographyWorks = photographyWorksService.selectById(id);
        if(type.equals("1")) {
        	photographyWorks.setThumbsupNum(photographyWorks.getThumbsupNum()+1);
        } else {
        	photographyWorks.setCrazilyNum(photographyWorks.getCrazilyNum()+1);
        }
        photographyWorksService.updateById(photographyWorks);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PhotographyWorksEntity photographyWorks, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(photographyWorks);
        photographyWorksService.insert(photographyWorks);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PhotographyWorksEntity photographyWorks, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(photographyWorks);
        photographyWorksService.insert(photographyWorks);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PhotographyWorksEntity photographyWorks, HttpServletRequest request){
        //ValidatorUtils.validateEntity(photographyWorks);
        photographyWorksService.updateById(photographyWorks);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        photographyWorksService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,PhotographyWorksEntity photographyWorks, HttpServletRequest request,String pre){
        EntityWrapper<PhotographyWorksEntity> ew = new EntityWrapper<PhotographyWorksEntity>();
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
		params.put("sort", "clickNum");
        params.put("order", "desc");
		PageUtils page = photographyWorksService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyWorks), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,PhotographyWorksEntity photographyWorks, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<OrdersEntity> orders = ordersService.selectList(new EntityWrapper<OrdersEntity>());
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(orders!=null && orders.size()>0) {
            for(OrdersEntity o : orders) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(o.getUserId().toString())) {
                    userRatings = ratings.get(o.getUserId().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(o.getUserId().toString(), userRatings);
                }
                if(userRatings.containsKey(o.getProductId().toString())) {
                    userRatings.put(o.getProductId().toString(), userRatings.get(o.getProductId().toString())+1.0);
                } else {
                    userRatings.put(o.getProductId().toString(), 1.0);
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

        EntityWrapper<PhotographyWorksEntity> ew = new EntityWrapper<PhotographyWorksEntity>();
        ew.in("id", recommendations);
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+String.join(",", recommendations)+")");
        }

        PageUtils page = photographyWorksService.queryPage(params, ew);
        List<PhotographyWorksEntity> pageList = (List<PhotographyWorksEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<PhotographyWorksEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(photographyWorksService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }








}

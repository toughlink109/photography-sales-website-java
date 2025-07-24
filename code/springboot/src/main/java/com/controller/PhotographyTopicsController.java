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
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.PhotographyTopicsEntity;
import com.entity.view.PhotographyTopicsView;

import com.service.PhotographyTopicsService;
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
 * 摄影话题
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/photographyTopics")
public class PhotographyTopicsController {
    @Autowired
    private PhotographyTopicsService photographyTopicsService;

    @Autowired
    private FavoritesService favoritesService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PhotographyTopicsEntity photographyTopics,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("ordinaryUser")) {
			photographyTopics.setAccount((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PhotographyTopicsEntity> ew = new EntityWrapper<PhotographyTopicsEntity>();

		PageUtils page = photographyTopicsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyTopics), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PhotographyTopicsEntity photographyTopics, 
		HttpServletRequest request){
        EntityWrapper<PhotographyTopicsEntity> ew = new EntityWrapper<PhotographyTopicsEntity>();

		PageUtils page = photographyTopicsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyTopics), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PhotographyTopicsEntity photographyTopics){
       	EntityWrapper<PhotographyTopicsEntity> ew = new EntityWrapper<PhotographyTopicsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( photographyTopics, "photographyTopics")); 
        return R.ok().put("data", photographyTopicsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PhotographyTopicsEntity photographyTopics){
        EntityWrapper< PhotographyTopicsEntity> ew = new EntityWrapper< PhotographyTopicsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( photographyTopics, "photographyTopics")); 
		PhotographyTopicsView photographyTopicsView =  photographyTopicsService.selectView(ew);
		return R.ok("查询摄影话题成功").put("data", photographyTopicsView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PhotographyTopicsEntity photographyTopics = photographyTopicsService.selectById(id);
		photographyTopics.setClickNum(photographyTopics.getClickNum()+1);
		photographyTopicsService.updateById(photographyTopics);
        photographyTopics = photographyTopicsService.selectView(new EntityWrapper<PhotographyTopicsEntity>().eq("id", id));
        return R.ok().put("data", photographyTopics);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PhotographyTopicsEntity photographyTopics = photographyTopicsService.selectById(id);
		photographyTopics.setClickNum(photographyTopics.getClickNum()+1);
		photographyTopicsService.updateById(photographyTopics);
        photographyTopics = photographyTopicsService.selectView(new EntityWrapper<PhotographyTopicsEntity>().eq("id", id));
        return R.ok().put("data", photographyTopics);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        PhotographyTopicsEntity photographyTopics = photographyTopicsService.selectById(id);
        if(type.equals("1")) {
        	photographyTopics.setThumbsupNum(photographyTopics.getThumbsupNum()+1);
        } else {
        	photographyTopics.setCrazilyNum(photographyTopics.getCrazilyNum()+1);
        }
        photographyTopicsService.updateById(photographyTopics);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PhotographyTopicsEntity photographyTopics, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(photographyTopics);
        photographyTopicsService.insert(photographyTopics);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PhotographyTopicsEntity photographyTopics, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(photographyTopics);
        photographyTopicsService.insert(photographyTopics);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PhotographyTopicsEntity photographyTopics, HttpServletRequest request){
        //ValidatorUtils.validateEntity(photographyTopics);
        photographyTopicsService.updateById(photographyTopics);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String isApproved, @RequestParam String approvedComments){
        List<PhotographyTopicsEntity> list = new ArrayList<PhotographyTopicsEntity>();
        for(Long id : ids) {
            PhotographyTopicsEntity photographyTopics = photographyTopicsService.selectById(id);
            photographyTopics.setIsApproved(isApproved);
            photographyTopics.setApprovedComments(approvedComments);
            list.add(photographyTopics);
        }
        photographyTopicsService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        photographyTopicsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,PhotographyTopicsEntity photographyTopics, HttpServletRequest request,String pre){
        EntityWrapper<PhotographyTopicsEntity> ew = new EntityWrapper<PhotographyTopicsEntity>();
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
		PageUtils page = photographyTopicsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, photographyTopics), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,PhotographyTopicsEntity photographyTopics, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<FavoritesEntity> favoritess = favoritesService.selectList(new EntityWrapper<FavoritesEntity>().eq("type", 1).eq("tableName", "photographyTopics"));
        Map<String, Map<String, Double>> ratings = new HashMap<>();
        if(favoritess!=null && favoritess.size()>0) {
            for(FavoritesEntity favorites : favoritess) {
                Map<String, Double> userRatings = null;
                if(ratings.containsKey(favorites.getUserId().toString())) {
                    userRatings = ratings.get(favorites.getUserId().toString());
                } else {
                    userRatings = new HashMap<>();
                    ratings.put(favorites.getUserId().toString(), userRatings);
                }

                if(userRatings.containsKey(favorites.getRefId().toString())) {
                    userRatings.put(favorites.getRefId().toString(), userRatings.get(favorites.getRefId().toString())+1.0);
                } else {
                    userRatings.put(favorites.getRefId().toString(), 1.0);
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

        EntityWrapper<PhotographyTopicsEntity> ew = new EntityWrapper<PhotographyTopicsEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        PageUtils page = photographyTopicsService.queryPage(params, ew);
        List<PhotographyTopicsEntity> pageList = (List<PhotographyTopicsEntity>)page.getList();
        if(pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<PhotographyTopicsEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(photographyTopicsService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }








}

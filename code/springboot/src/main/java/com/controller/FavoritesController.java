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

import com.entity.FavoritesEntity;
import com.entity.view.FavoritesView;

import com.service.FavoritesService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 收藏表
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FavoritesEntity favorites,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            favorites.setUserId((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<FavoritesEntity> ew = new EntityWrapper<FavoritesEntity>();

		PageUtils page = favoritesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, favorites), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FavoritesEntity favorites, 
		HttpServletRequest request){
        EntityWrapper<FavoritesEntity> ew = new EntityWrapper<FavoritesEntity>();

		PageUtils page = favoritesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, favorites), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FavoritesEntity favorites){
       	EntityWrapper<FavoritesEntity> ew = new EntityWrapper<FavoritesEntity>();
      	ew.allEq(MPUtil.allEQMapPre( favorites, "favorites")); 
        return R.ok().put("data", favoritesService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FavoritesEntity favorites){
        EntityWrapper< FavoritesEntity> ew = new EntityWrapper< FavoritesEntity>();
 		ew.allEq(MPUtil.allEQMapPre( favorites, "favorites")); 
		FavoritesView favoritesView =  favoritesService.selectView(ew);
		return R.ok("查询收藏表成功").put("data", favoritesView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FavoritesEntity favorites = favoritesService.selectById(id);
        return R.ok().put("data", favorites);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FavoritesEntity favorites = favoritesService.selectById(id);
        return R.ok().put("data", favorites);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FavoritesEntity favorites, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(favorites);
    	favorites.setUserId((Long)request.getSession().getAttribute("userId"));
        favoritesService.insert(favorites);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FavoritesEntity favorites, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(favorites);
        favoritesService.insert(favorites);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        FavoritesEntity favorites = favoritesService.selectOne(new EntityWrapper<FavoritesEntity>().eq("", username));
        return R.ok().put("data", favorites);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody FavoritesEntity favorites, HttpServletRequest request){
        //ValidatorUtils.validateEntity(favorites);
        favoritesService.updateById(favorites);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        favoritesService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FavoritesEntity favorites, HttpServletRequest request,String pre){
        EntityWrapper<FavoritesEntity> ew = new EntityWrapper<FavoritesEntity>();
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
		PageUtils page = favoritesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, favorites), params), params));
        return R.ok().put("data", page);
    }










}

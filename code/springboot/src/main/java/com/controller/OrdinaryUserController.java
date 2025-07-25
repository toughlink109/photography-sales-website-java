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

import com.entity.OrdinaryUserEntity;
import com.entity.view.OrdinaryUserView;

import com.service.OrdinaryUserService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 用户
 * 后端接口
 * @author 
 * @email 
 */
@RestController
@RequestMapping("/ordinaryUser")
public class OrdinaryUserController {
    @Autowired
    private OrdinaryUserService ordinaryUserService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		OrdinaryUserEntity u = ordinaryUserService.selectOne(new EntityWrapper<OrdinaryUserEntity>().eq("account", username));
		if(u==null || !u.getPassword().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"ordinaryUser",  "用户" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody OrdinaryUserEntity ordinaryUser){
    	//ValidatorUtils.validateEntity(ordinaryUser);
    	OrdinaryUserEntity u = ordinaryUserService.selectOne(new EntityWrapper<OrdinaryUserEntity>().eq("account", ordinaryUser.getAccount()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		ordinaryUser.setId(uId);
        ordinaryUserService.insert(ordinaryUser);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        OrdinaryUserEntity u = ordinaryUserService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	OrdinaryUserEntity u = ordinaryUserService.selectOne(new EntityWrapper<OrdinaryUserEntity>().eq("account", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setPassword("123456");
        ordinaryUserService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,OrdinaryUserEntity ordinaryUser,
		HttpServletRequest request){
        EntityWrapper<OrdinaryUserEntity> ew = new EntityWrapper<OrdinaryUserEntity>();

		PageUtils page = ordinaryUserService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ordinaryUser), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,OrdinaryUserEntity ordinaryUser, 
		HttpServletRequest request){
        EntityWrapper<OrdinaryUserEntity> ew = new EntityWrapper<OrdinaryUserEntity>();

		PageUtils page = ordinaryUserService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ordinaryUser), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( OrdinaryUserEntity ordinaryUser){
       	EntityWrapper<OrdinaryUserEntity> ew = new EntityWrapper<OrdinaryUserEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ordinaryUser, "ordinaryUser")); 
        return R.ok().put("data", ordinaryUserService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(OrdinaryUserEntity ordinaryUser){
        EntityWrapper< OrdinaryUserEntity> ew = new EntityWrapper< OrdinaryUserEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ordinaryUser, "ordinaryUser")); 
		OrdinaryUserView ordinaryUserView =  ordinaryUserService.selectView(ew);
		return R.ok("查询用户成功").put("data", ordinaryUserView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        OrdinaryUserEntity ordinaryUser = ordinaryUserService.selectById(id);
        return R.ok().put("data", ordinaryUser);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        OrdinaryUserEntity ordinaryUser = ordinaryUserService.selectById(id);
        return R.ok().put("data", ordinaryUser);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrdinaryUserEntity ordinaryUser, HttpServletRequest request){
        if(ordinaryUserService.selectCount(new EntityWrapper<OrdinaryUserEntity>().eq("account", ordinaryUser.getAccount()))>0) {
            return R.error("账号已存在");
        }
    	ordinaryUser.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ordinaryUser);
    	OrdinaryUserEntity u = ordinaryUserService.selectOne(new EntityWrapper<OrdinaryUserEntity>().eq("account", ordinaryUser.getAccount()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		ordinaryUser.setId(new Date().getTime());
        ordinaryUserService.insert(ordinaryUser);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody OrdinaryUserEntity ordinaryUser, HttpServletRequest request){
        if(ordinaryUserService.selectCount(new EntityWrapper<OrdinaryUserEntity>().eq("account", ordinaryUser.getAccount()))>0) {
            return R.error("账号已存在");
        }
    	ordinaryUser.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ordinaryUser);
    	OrdinaryUserEntity u = ordinaryUserService.selectOne(new EntityWrapper<OrdinaryUserEntity>().eq("account", ordinaryUser.getAccount()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		ordinaryUser.setId(new Date().getTime());
        ordinaryUserService.insert(ordinaryUser);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody OrdinaryUserEntity ordinaryUser, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ordinaryUser);
        if(ordinaryUserService.selectCount(new EntityWrapper<OrdinaryUserEntity>().ne("id", ordinaryUser.getId()).eq("account", ordinaryUser.getAccount()))>0) {
            return R.error("账号已存在");
        }
        ordinaryUserService.updateById(ordinaryUser);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ordinaryUserService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

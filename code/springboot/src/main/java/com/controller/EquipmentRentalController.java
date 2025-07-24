package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.service.EquipmentRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.annotation.IgnoreAuth;

import com.entity.EquipmentRentalEntity;
import com.entity.view.EquipmentRentalView;

import com.service.EquipmentRentalService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 摄影设备租用
 * 后端接口
 * @author
 * @email
 */
@RestController
@RequestMapping("/equipmentRental")
public class EquipmentRentalController {
    @Autowired
    private EquipmentRentalService equipmentRentalService;




    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,EquipmentRentalEntity equipmentRental,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("ordinaryUser")) {
			equipmentRental.setAccount((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<EquipmentRentalEntity> ew = new EntityWrapper<EquipmentRentalEntity>();

		PageUtils page = equipmentRentalService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, equipmentRental), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,EquipmentRentalEntity equipmentRental,
		HttpServletRequest request){
        EntityWrapper<EquipmentRentalEntity> ew = new EntityWrapper<EquipmentRentalEntity>();

		PageUtils page = equipmentRentalService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, equipmentRental), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( EquipmentRentalEntity equipmentRental){
       	EntityWrapper<EquipmentRentalEntity> ew = new EntityWrapper<EquipmentRentalEntity>();
      	ew.allEq(MPUtil.allEQMapPre( equipmentRental, "equipmentRental"));
        return R.ok().put("data", equipmentRentalService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(EquipmentRentalEntity equipmentRental){
        EntityWrapper< EquipmentRentalEntity> ew = new EntityWrapper< EquipmentRentalEntity>();
 		ew.allEq(MPUtil.allEQMapPre( equipmentRental, "equipmentRental"));
		EquipmentRentalView EquipmentRentalView =  equipmentRentalService.selectView(ew);
		return R.ok("查询摄影设备租用成功").put("data", EquipmentRentalView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        EquipmentRentalEntity equipmentRental = equipmentRentalService.selectById(id);
        return R.ok().put("data", equipmentRental);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        EquipmentRentalEntity equipmentRental = equipmentRentalService.selectById(id);
        return R.ok().put("data", equipmentRental);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EquipmentRentalEntity equipmentRental, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(equipmentRental);
        equipmentRentalService.insert(equipmentRental);
        return R.ok();
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody EquipmentRentalEntity equipmentRental, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(equipmentRental);
        equipmentRentalService.insert(equipmentRental);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody EquipmentRentalEntity equipmentRental, HttpServletRequest request){
        //ValidatorUtils.validateEntity(equipmentRental);
        equipmentRentalService.updateById(equipmentRental);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String isApproved, @RequestParam String approvedComments){
        List<EquipmentRentalEntity> list = new ArrayList<EquipmentRentalEntity>();
        for(Long id : ids) {
            EquipmentRentalEntity equipmentRental = equipmentRentalService.selectById(id);
            equipmentRental.setIsApproved(isApproved);
            equipmentRental.setApprovedComments(approvedComments);
            list.add(equipmentRental);
        }
        equipmentRentalService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        equipmentRentalService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }












}

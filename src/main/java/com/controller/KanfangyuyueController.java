package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KanfangyuyueEntity;
import com.entity.view.KanfangyuyueView;

import com.service.KanfangyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 看房预约
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
@RestController
@RequestMapping("/kanfangyuyue")
public class KanfangyuyueController {
    @Autowired
    private KanfangyuyueService kanfangyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KanfangyuyueEntity kanfangyuyue, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			kanfangyuyue.setJingjirenhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			kanfangyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KanfangyuyueEntity> ew = new EntityWrapper<KanfangyuyueEntity>();
		PageUtils page = kanfangyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kanfangyuyue), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KanfangyuyueEntity kanfangyuyue, 
		HttpServletRequest request){
        EntityWrapper<KanfangyuyueEntity> ew = new EntityWrapper<KanfangyuyueEntity>();
		PageUtils page = kanfangyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kanfangyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KanfangyuyueEntity kanfangyuyue){
       	EntityWrapper<KanfangyuyueEntity> ew = new EntityWrapper<KanfangyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kanfangyuyue, "kanfangyuyue")); 
        return R.ok().put("data", kanfangyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KanfangyuyueEntity kanfangyuyue){
        EntityWrapper< KanfangyuyueEntity> ew = new EntityWrapper< KanfangyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kanfangyuyue, "kanfangyuyue")); 
		KanfangyuyueView kanfangyuyueView =  kanfangyuyueService.selectView(ew);
		return R.ok("查询看房预约成功").put("data", kanfangyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KanfangyuyueEntity kanfangyuyue = kanfangyuyueService.selectById(id);
        return R.ok().put("data", kanfangyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KanfangyuyueEntity kanfangyuyue = kanfangyuyueService.selectById(id);
        return R.ok().put("data", kanfangyuyue);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        KanfangyuyueEntity kanfangyuyue = kanfangyuyueService.selectById(id);
        if(type.equals("1")) {
        	kanfangyuyue.setThumbsupnum(kanfangyuyue.getThumbsupnum()+1);
        } else {
        	kanfangyuyue.setCrazilynum(kanfangyuyue.getCrazilynum()+1);
        }
        kanfangyuyueService.updateById(kanfangyuyue);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KanfangyuyueEntity kanfangyuyue, HttpServletRequest request){
    	kanfangyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kanfangyuyue);

        kanfangyuyueService.insert(kanfangyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KanfangyuyueEntity kanfangyuyue, HttpServletRequest request){
    	kanfangyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kanfangyuyue);

        kanfangyuyueService.insert(kanfangyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KanfangyuyueEntity kanfangyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kanfangyuyue);
        kanfangyuyueService.updateById(kanfangyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kanfangyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<KanfangyuyueEntity> wrapper = new EntityWrapper<KanfangyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			wrapper.eq("jingjirenhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = kanfangyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

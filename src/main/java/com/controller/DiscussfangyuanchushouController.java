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

import com.entity.DiscussfangyuanchushouEntity;
import com.entity.view.DiscussfangyuanchushouView;

import com.service.DiscussfangyuanchushouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 房源出售评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-15 20:56:29
 */
@RestController
@RequestMapping("/discussfangyuanchushou")
public class DiscussfangyuanchushouController {
    @Autowired
    private DiscussfangyuanchushouService discussfangyuanchushouService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussfangyuanchushouEntity discussfangyuanchushou, 
		HttpServletRequest request){

        EntityWrapper<DiscussfangyuanchushouEntity> ew = new EntityWrapper<DiscussfangyuanchushouEntity>();
		PageUtils page = discussfangyuanchushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchushou), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussfangyuanchushouEntity discussfangyuanchushou, 
		HttpServletRequest request){
        EntityWrapper<DiscussfangyuanchushouEntity> ew = new EntityWrapper<DiscussfangyuanchushouEntity>();
		PageUtils page = discussfangyuanchushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchushou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussfangyuanchushouEntity discussfangyuanchushou){
       	EntityWrapper<DiscussfangyuanchushouEntity> ew = new EntityWrapper<DiscussfangyuanchushouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussfangyuanchushou, "discussfangyuanchushou")); 
        return R.ok().put("data", discussfangyuanchushouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussfangyuanchushouEntity discussfangyuanchushou){
        EntityWrapper< DiscussfangyuanchushouEntity> ew = new EntityWrapper< DiscussfangyuanchushouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussfangyuanchushou, "discussfangyuanchushou")); 
		DiscussfangyuanchushouView discussfangyuanchushouView =  discussfangyuanchushouService.selectView(ew);
		return R.ok("查询房源出售评论表成功").put("data", discussfangyuanchushouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussfangyuanchushouEntity discussfangyuanchushou = discussfangyuanchushouService.selectById(id);
        return R.ok().put("data", discussfangyuanchushou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussfangyuanchushouEntity discussfangyuanchushou = discussfangyuanchushouService.selectById(id);
        return R.ok().put("data", discussfangyuanchushou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussfangyuanchushouEntity discussfangyuanchushou, HttpServletRequest request){
    	discussfangyuanchushou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfangyuanchushou);

        discussfangyuanchushouService.insert(discussfangyuanchushou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussfangyuanchushouEntity discussfangyuanchushou, HttpServletRequest request){
    	discussfangyuanchushou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfangyuanchushou);

        discussfangyuanchushouService.insert(discussfangyuanchushou);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussfangyuanchushouEntity discussfangyuanchushou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussfangyuanchushou);
        discussfangyuanchushouService.updateById(discussfangyuanchushou);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussfangyuanchushouService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussfangyuanchushouEntity> wrapper = new EntityWrapper<DiscussfangyuanchushouEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussfangyuanchushouService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

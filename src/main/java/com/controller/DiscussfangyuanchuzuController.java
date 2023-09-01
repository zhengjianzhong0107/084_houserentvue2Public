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

import com.entity.DiscussfangyuanchuzuEntity;
import com.entity.view.DiscussfangyuanchuzuView;

import com.service.DiscussfangyuanchuzuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 房源出租评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-15 20:56:29
 */
@RestController
@RequestMapping("/discussfangyuanchuzu")
public class DiscussfangyuanchuzuController {
    @Autowired
    private DiscussfangyuanchuzuService discussfangyuanchuzuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussfangyuanchuzuEntity discussfangyuanchuzu, 
		HttpServletRequest request){

        EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();
		PageUtils page = discussfangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussfangyuanchuzuEntity discussfangyuanchuzu, 
		HttpServletRequest request){
        EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();
		PageUtils page = discussfangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussfangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussfangyuanchuzuEntity discussfangyuanchuzu){
       	EntityWrapper<DiscussfangyuanchuzuEntity> ew = new EntityWrapper<DiscussfangyuanchuzuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussfangyuanchuzu, "discussfangyuanchuzu")); 
        return R.ok().put("data", discussfangyuanchuzuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussfangyuanchuzuEntity discussfangyuanchuzu){
        EntityWrapper< DiscussfangyuanchuzuEntity> ew = new EntityWrapper< DiscussfangyuanchuzuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussfangyuanchuzu, "discussfangyuanchuzu")); 
		DiscussfangyuanchuzuView discussfangyuanchuzuView =  discussfangyuanchuzuService.selectView(ew);
		return R.ok("查询房源出租评论表成功").put("data", discussfangyuanchuzuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussfangyuanchuzuEntity discussfangyuanchuzu = discussfangyuanchuzuService.selectById(id);
        return R.ok().put("data", discussfangyuanchuzu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussfangyuanchuzuEntity discussfangyuanchuzu = discussfangyuanchuzuService.selectById(id);
        return R.ok().put("data", discussfangyuanchuzu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request){
    	discussfangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfangyuanchuzu);

        discussfangyuanchuzuService.insert(discussfangyuanchuzu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request){
    	discussfangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussfangyuanchuzu);

        discussfangyuanchuzuService.insert(discussfangyuanchuzu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussfangyuanchuzuEntity discussfangyuanchuzu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussfangyuanchuzu);
        discussfangyuanchuzuService.updateById(discussfangyuanchuzu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussfangyuanchuzuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussfangyuanchuzuEntity> wrapper = new EntityWrapper<DiscussfangyuanchuzuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussfangyuanchuzuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

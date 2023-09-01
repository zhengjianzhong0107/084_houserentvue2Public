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

import com.entity.FangyuanchuzuEntity;
import com.entity.view.FangyuanchuzuView;

import com.service.FangyuanchuzuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 房源出租
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
@RestController
@RequestMapping("/fangyuanchuzu")
public class FangyuanchuzuController {
    @Autowired
    private FangyuanchuzuService fangyuanchuzuService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangyuanchuzuEntity fangyuanchuzu, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			fangyuanchuzu.setJingjirenhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
		PageUtils page = fangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangyuanchuzuEntity fangyuanchuzu, 
		HttpServletRequest request){
        EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
		PageUtils page = fangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangyuanchuzuEntity fangyuanchuzu){
       	EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangyuanchuzu, "fangyuanchuzu")); 
        return R.ok().put("data", fangyuanchuzuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangyuanchuzuEntity fangyuanchuzu){
        EntityWrapper< FangyuanchuzuEntity> ew = new EntityWrapper< FangyuanchuzuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangyuanchuzu, "fangyuanchuzu")); 
		FangyuanchuzuView fangyuanchuzuView =  fangyuanchuzuService.selectView(ew);
		return R.ok("查询房源出租成功").put("data", fangyuanchuzuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangyuanchuzuEntity fangyuanchuzu = fangyuanchuzuService.selectById(id);
		fangyuanchuzu.setClicknum(fangyuanchuzu.getClicknum()+1);
		fangyuanchuzu.setClicktime(new Date());
		fangyuanchuzuService.updateById(fangyuanchuzu);
        return R.ok().put("data", fangyuanchuzu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangyuanchuzuEntity fangyuanchuzu = fangyuanchuzuService.selectById(id);
		fangyuanchuzu.setClicknum(fangyuanchuzu.getClicknum()+1);
		fangyuanchuzu.setClicktime(new Date());
		fangyuanchuzuService.updateById(fangyuanchuzu);
        return R.ok().put("data", fangyuanchuzu);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        FangyuanchuzuEntity fangyuanchuzu = fangyuanchuzuService.selectById(id);
        if(type.equals("1")) {
        	fangyuanchuzu.setThumbsupnum(fangyuanchuzu.getThumbsupnum()+1);
        } else {
        	fangyuanchuzu.setCrazilynum(fangyuanchuzu.getCrazilynum()+1);
        }
        fangyuanchuzuService.updateById(fangyuanchuzu);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request){
    	fangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanchuzu);

        fangyuanchuzuService.insert(fangyuanchuzu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request){
    	fangyuanchuzu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangyuanchuzu);

        fangyuanchuzuService.insert(fangyuanchuzu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangyuanchuzu);
        fangyuanchuzuService.updateById(fangyuanchuzu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangyuanchuzuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<FangyuanchuzuEntity> wrapper = new EntityWrapper<FangyuanchuzuEntity>();
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

		int count = fangyuanchuzuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FangyuanchuzuEntity fangyuanchuzu, HttpServletRequest request,String pre){
        EntityWrapper<FangyuanchuzuEntity> ew = new EntityWrapper<FangyuanchuzuEntity>();
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
		PageUtils page = fangyuanchuzuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangyuanchuzu), params), params));
        return R.ok().put("data", page);
    }







}

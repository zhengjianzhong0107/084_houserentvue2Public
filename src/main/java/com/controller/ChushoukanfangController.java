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

import com.entity.ChushoukanfangEntity;
import com.entity.view.ChushoukanfangView;

import com.service.ChushoukanfangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 出售看房
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
@RestController
@RequestMapping("/chushoukanfang")
public class ChushoukanfangController {
    @Autowired
    private ChushoukanfangService chushoukanfangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChushoukanfangEntity chushoukanfang, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jingjiren")) {
			chushoukanfang.setJingjirenhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			chushoukanfang.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChushoukanfangEntity> ew = new EntityWrapper<ChushoukanfangEntity>();
		PageUtils page = chushoukanfangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chushoukanfang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChushoukanfangEntity chushoukanfang, 
		HttpServletRequest request){
        EntityWrapper<ChushoukanfangEntity> ew = new EntityWrapper<ChushoukanfangEntity>();
		PageUtils page = chushoukanfangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chushoukanfang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChushoukanfangEntity chushoukanfang){
       	EntityWrapper<ChushoukanfangEntity> ew = new EntityWrapper<ChushoukanfangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chushoukanfang, "chushoukanfang")); 
        return R.ok().put("data", chushoukanfangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChushoukanfangEntity chushoukanfang){
        EntityWrapper< ChushoukanfangEntity> ew = new EntityWrapper< ChushoukanfangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chushoukanfang, "chushoukanfang")); 
		ChushoukanfangView chushoukanfangView =  chushoukanfangService.selectView(ew);
		return R.ok("查询出售看房成功").put("data", chushoukanfangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChushoukanfangEntity chushoukanfang = chushoukanfangService.selectById(id);
        return R.ok().put("data", chushoukanfang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChushoukanfangEntity chushoukanfang = chushoukanfangService.selectById(id);
        return R.ok().put("data", chushoukanfang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChushoukanfangEntity chushoukanfang, HttpServletRequest request){
    	chushoukanfang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chushoukanfang);

        chushoukanfangService.insert(chushoukanfang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChushoukanfangEntity chushoukanfang, HttpServletRequest request){
    	chushoukanfang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chushoukanfang);

        chushoukanfangService.insert(chushoukanfang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChushoukanfangEntity chushoukanfang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chushoukanfang);
        chushoukanfangService.updateById(chushoukanfang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chushoukanfangService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ChushoukanfangEntity> wrapper = new EntityWrapper<ChushoukanfangEntity>();
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

		int count = chushoukanfangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

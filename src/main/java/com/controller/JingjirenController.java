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

import com.entity.JingjirenEntity;
import com.entity.view.JingjirenView;

import com.service.JingjirenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 经纪人
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
@RestController
@RequestMapping("/jingjiren")
public class JingjirenController {
    @Autowired
    private JingjirenService jingjirenService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		JingjirenEntity user = jingjirenService.selectOne(new EntityWrapper<JingjirenEntity>().eq("jingjirenhao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"jingjiren",  "经纪人" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody JingjirenEntity jingjiren){
    	//ValidatorUtils.validateEntity(jingjiren);
    	JingjirenEntity user = jingjirenService.selectOne(new EntityWrapper<JingjirenEntity>().eq("jingjirenhao", jingjiren.getJingjirenhao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		jingjiren.setId(uId);
        jingjirenService.insert(jingjiren);
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
        JingjirenEntity user = jingjirenService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	JingjirenEntity user = jingjirenService.selectOne(new EntityWrapper<JingjirenEntity>().eq("jingjirenhao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        jingjirenService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingjirenEntity jingjiren, 
		HttpServletRequest request){

        EntityWrapper<JingjirenEntity> ew = new EntityWrapper<JingjirenEntity>();
		PageUtils page = jingjirenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingjiren), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingjirenEntity jingjiren, 
		HttpServletRequest request){
        EntityWrapper<JingjirenEntity> ew = new EntityWrapper<JingjirenEntity>();
		PageUtils page = jingjirenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingjiren), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingjirenEntity jingjiren){
       	EntityWrapper<JingjirenEntity> ew = new EntityWrapper<JingjirenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingjiren, "jingjiren")); 
        return R.ok().put("data", jingjirenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingjirenEntity jingjiren){
        EntityWrapper< JingjirenEntity> ew = new EntityWrapper< JingjirenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingjiren, "jingjiren")); 
		JingjirenView jingjirenView =  jingjirenService.selectView(ew);
		return R.ok("查询经纪人成功").put("data", jingjirenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingjirenEntity jingjiren = jingjirenService.selectById(id);
        return R.ok().put("data", jingjiren);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingjirenEntity jingjiren = jingjirenService.selectById(id);
        return R.ok().put("data", jingjiren);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingjirenEntity jingjiren, HttpServletRequest request){
    	jingjiren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingjiren);
    	JingjirenEntity user = jingjirenService.selectOne(new EntityWrapper<JingjirenEntity>().eq("jingjirenhao", jingjiren.getJingjirenhao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		jingjiren.setId(new Date().getTime());
        jingjirenService.insert(jingjiren);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingjirenEntity jingjiren, HttpServletRequest request){
    	jingjiren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingjiren);
    	JingjirenEntity user = jingjirenService.selectOne(new EntityWrapper<JingjirenEntity>().eq("jingjirenhao", jingjiren.getJingjirenhao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		jingjiren.setId(new Date().getTime());
        jingjirenService.insert(jingjiren);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JingjirenEntity jingjiren, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingjiren);
        jingjirenService.updateById(jingjiren);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingjirenService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JingjirenEntity> wrapper = new EntityWrapper<JingjirenEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jingjirenService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

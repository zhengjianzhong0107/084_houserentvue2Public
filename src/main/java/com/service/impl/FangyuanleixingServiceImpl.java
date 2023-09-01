package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FangyuanleixingDao;
import com.entity.FangyuanleixingEntity;
import com.service.FangyuanleixingService;
import com.entity.vo.FangyuanleixingVO;
import com.entity.view.FangyuanleixingView;

@Service("fangyuanleixingService")
public class FangyuanleixingServiceImpl extends ServiceImpl<FangyuanleixingDao, FangyuanleixingEntity> implements FangyuanleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuanleixingEntity> page = this.selectPage(
                new Query<FangyuanleixingEntity>(params).getPage(),
                new EntityWrapper<FangyuanleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangyuanleixingEntity> wrapper) {
		  Page<FangyuanleixingView> page =new Query<FangyuanleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FangyuanleixingVO> selectListVO(Wrapper<FangyuanleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangyuanleixingVO selectVO(Wrapper<FangyuanleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangyuanleixingView> selectListView(Wrapper<FangyuanleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuanleixingView selectView(Wrapper<FangyuanleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

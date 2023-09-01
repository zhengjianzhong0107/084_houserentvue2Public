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


import com.dao.FangyuangoumaiDao;
import com.entity.FangyuangoumaiEntity;
import com.service.FangyuangoumaiService;
import com.entity.vo.FangyuangoumaiVO;
import com.entity.view.FangyuangoumaiView;

@Service("fangyuangoumaiService")
public class FangyuangoumaiServiceImpl extends ServiceImpl<FangyuangoumaiDao, FangyuangoumaiEntity> implements FangyuangoumaiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuangoumaiEntity> page = this.selectPage(
                new Query<FangyuangoumaiEntity>(params).getPage(),
                new EntityWrapper<FangyuangoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangyuangoumaiEntity> wrapper) {
		  Page<FangyuangoumaiView> page =new Query<FangyuangoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FangyuangoumaiVO> selectListVO(Wrapper<FangyuangoumaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangyuangoumaiVO selectVO(Wrapper<FangyuangoumaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangyuangoumaiView> selectListView(Wrapper<FangyuangoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuangoumaiView selectView(Wrapper<FangyuangoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

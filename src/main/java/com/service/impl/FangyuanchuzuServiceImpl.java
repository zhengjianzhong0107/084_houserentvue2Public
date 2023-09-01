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


import com.dao.FangyuanchuzuDao;
import com.entity.FangyuanchuzuEntity;
import com.service.FangyuanchuzuService;
import com.entity.vo.FangyuanchuzuVO;
import com.entity.view.FangyuanchuzuView;

@Service("fangyuanchuzuService")
public class FangyuanchuzuServiceImpl extends ServiceImpl<FangyuanchuzuDao, FangyuanchuzuEntity> implements FangyuanchuzuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangyuanchuzuEntity> page = this.selectPage(
                new Query<FangyuanchuzuEntity>(params).getPage(),
                new EntityWrapper<FangyuanchuzuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangyuanchuzuEntity> wrapper) {
		  Page<FangyuanchuzuView> page =new Query<FangyuanchuzuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FangyuanchuzuVO> selectListVO(Wrapper<FangyuanchuzuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangyuanchuzuVO selectVO(Wrapper<FangyuanchuzuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangyuanchuzuView> selectListView(Wrapper<FangyuanchuzuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangyuanchuzuView selectView(Wrapper<FangyuanchuzuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

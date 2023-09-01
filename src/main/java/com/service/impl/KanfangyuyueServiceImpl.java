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


import com.dao.KanfangyuyueDao;
import com.entity.KanfangyuyueEntity;
import com.service.KanfangyuyueService;
import com.entity.vo.KanfangyuyueVO;
import com.entity.view.KanfangyuyueView;

@Service("kanfangyuyueService")
public class KanfangyuyueServiceImpl extends ServiceImpl<KanfangyuyueDao, KanfangyuyueEntity> implements KanfangyuyueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KanfangyuyueEntity> page = this.selectPage(
                new Query<KanfangyuyueEntity>(params).getPage(),
                new EntityWrapper<KanfangyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KanfangyuyueEntity> wrapper) {
		  Page<KanfangyuyueView> page =new Query<KanfangyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KanfangyuyueVO> selectListVO(Wrapper<KanfangyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KanfangyuyueVO selectVO(Wrapper<KanfangyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KanfangyuyueView> selectListView(Wrapper<KanfangyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KanfangyuyueView selectView(Wrapper<KanfangyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.dao.JingjirenDao;
import com.entity.JingjirenEntity;
import com.service.JingjirenService;
import com.entity.vo.JingjirenVO;
import com.entity.view.JingjirenView;

@Service("jingjirenService")
public class JingjirenServiceImpl extends ServiceImpl<JingjirenDao, JingjirenEntity> implements JingjirenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingjirenEntity> page = this.selectPage(
                new Query<JingjirenEntity>(params).getPage(),
                new EntityWrapper<JingjirenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingjirenEntity> wrapper) {
		  Page<JingjirenView> page =new Query<JingjirenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingjirenVO> selectListVO(Wrapper<JingjirenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingjirenVO selectVO(Wrapper<JingjirenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingjirenView> selectListView(Wrapper<JingjirenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingjirenView selectView(Wrapper<JingjirenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

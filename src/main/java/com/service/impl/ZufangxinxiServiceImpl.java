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


import com.dao.ZufangxinxiDao;
import com.entity.ZufangxinxiEntity;
import com.service.ZufangxinxiService;
import com.entity.vo.ZufangxinxiVO;
import com.entity.view.ZufangxinxiView;

@Service("zufangxinxiService")
public class ZufangxinxiServiceImpl extends ServiceImpl<ZufangxinxiDao, ZufangxinxiEntity> implements ZufangxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZufangxinxiEntity> page = this.selectPage(
                new Query<ZufangxinxiEntity>(params).getPage(),
                new EntityWrapper<ZufangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZufangxinxiEntity> wrapper) {
		  Page<ZufangxinxiView> page =new Query<ZufangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZufangxinxiVO> selectListVO(Wrapper<ZufangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZufangxinxiVO selectVO(Wrapper<ZufangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZufangxinxiView> selectListView(Wrapper<ZufangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZufangxinxiView selectView(Wrapper<ZufangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

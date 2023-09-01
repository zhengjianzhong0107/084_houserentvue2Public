package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangyuanleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangyuanleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanleixingView;


/**
 * 房源类型
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuanleixingService extends IService<FangyuanleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanleixingVO> selectListVO(Wrapper<FangyuanleixingEntity> wrapper);
   	
   	FangyuanleixingVO selectVO(@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);
   	
   	List<FangyuanleixingView> selectListView(Wrapper<FangyuanleixingEntity> wrapper);
   	
   	FangyuanleixingView selectView(@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanleixingEntity> wrapper);
   	

}


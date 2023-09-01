package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangyuanchushouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangyuanchushouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanchushouView;


/**
 * 房源出售
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuanchushouService extends IService<FangyuanchushouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanchushouVO> selectListVO(Wrapper<FangyuanchushouEntity> wrapper);
   	
   	FangyuanchushouVO selectVO(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
   	
   	List<FangyuanchushouView> selectListView(Wrapper<FangyuanchushouEntity> wrapper);
   	
   	FangyuanchushouView selectView(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanchushouEntity> wrapper);
   	

}


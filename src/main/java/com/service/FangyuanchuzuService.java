package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangyuanchuzuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangyuanchuzuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanchuzuView;


/**
 * 房源出租
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuanchuzuService extends IService<FangyuanchuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuanchuzuVO> selectListVO(Wrapper<FangyuanchuzuEntity> wrapper);
   	
   	FangyuanchuzuVO selectVO(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
   	
   	List<FangyuanchuzuView> selectListView(Wrapper<FangyuanchuzuEntity> wrapper);
   	
   	FangyuanchuzuView selectView(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuanchuzuEntity> wrapper);
   	

}


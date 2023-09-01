package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangyuangoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangyuangoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuangoumaiView;


/**
 * 房源购买
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuangoumaiService extends IService<FangyuangoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangyuangoumaiVO> selectListVO(Wrapper<FangyuangoumaiEntity> wrapper);
   	
   	FangyuangoumaiVO selectVO(@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);
   	
   	List<FangyuangoumaiView> selectListView(Wrapper<FangyuangoumaiEntity> wrapper);
   	
   	FangyuangoumaiView selectView(@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangyuangoumaiEntity> wrapper);
   	

}


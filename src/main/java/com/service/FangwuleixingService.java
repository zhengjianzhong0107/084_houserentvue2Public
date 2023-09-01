package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangwuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangwuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuleixingView;


/**
 * 房屋类型
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangwuleixingService extends IService<FangwuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuleixingVO> selectListVO(Wrapper<FangwuleixingEntity> wrapper);
   	
   	FangwuleixingVO selectVO(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
   	
   	List<FangwuleixingView> selectListView(Wrapper<FangwuleixingEntity> wrapper);
   	
   	FangwuleixingView selectView(@Param("ew") Wrapper<FangwuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuleixingEntity> wrapper);
   	

}


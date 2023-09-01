package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfangyuanchushouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfangyuanchushouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfangyuanchushouView;


/**
 * 房源出售评论表
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:29
 */
public interface DiscussfangyuanchushouService extends IService<DiscussfangyuanchushouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangyuanchushouVO> selectListVO(Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	
   	DiscussfangyuanchushouVO selectVO(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	
   	List<DiscussfangyuanchushouView> selectListView(Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	
   	DiscussfangyuanchushouView selectView(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangyuanchushouEntity> wrapper);
   	

}


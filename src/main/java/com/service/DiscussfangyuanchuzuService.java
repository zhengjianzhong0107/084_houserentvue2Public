package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussfangyuanchuzuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussfangyuanchuzuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussfangyuanchuzuView;


/**
 * 房源出租评论表
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:29
 */
public interface DiscussfangyuanchuzuService extends IService<DiscussfangyuanchuzuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfangyuanchuzuVO> selectListVO(Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	
   	DiscussfangyuanchuzuVO selectVO(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	
   	List<DiscussfangyuanchuzuView> selectListView(Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	
   	DiscussfangyuanchuzuView selectView(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfangyuanchuzuEntity> wrapper);
   	

}


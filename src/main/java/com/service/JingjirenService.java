package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingjirenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingjirenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingjirenView;


/**
 * 经纪人
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface JingjirenService extends IService<JingjirenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingjirenVO> selectListVO(Wrapper<JingjirenEntity> wrapper);
   	
   	JingjirenVO selectVO(@Param("ew") Wrapper<JingjirenEntity> wrapper);
   	
   	List<JingjirenView> selectListView(Wrapper<JingjirenEntity> wrapper);
   	
   	JingjirenView selectView(@Param("ew") Wrapper<JingjirenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingjirenEntity> wrapper);
   	

}


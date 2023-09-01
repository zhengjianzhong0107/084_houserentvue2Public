package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChushoukanfangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChushoukanfangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChushoukanfangView;


/**
 * 出售看房
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface ChushoukanfangService extends IService<ChushoukanfangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChushoukanfangVO> selectListVO(Wrapper<ChushoukanfangEntity> wrapper);
   	
   	ChushoukanfangVO selectVO(@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);
   	
   	List<ChushoukanfangView> selectListView(Wrapper<ChushoukanfangEntity> wrapper);
   	
   	ChushoukanfangView selectView(@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChushoukanfangEntity> wrapper);
   	

}


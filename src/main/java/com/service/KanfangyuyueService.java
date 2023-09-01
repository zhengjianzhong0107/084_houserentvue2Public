package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KanfangyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KanfangyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KanfangyuyueView;


/**
 * 看房预约
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface KanfangyuyueService extends IService<KanfangyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KanfangyuyueVO> selectListVO(Wrapper<KanfangyuyueEntity> wrapper);
   	
   	KanfangyuyueVO selectVO(@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);
   	
   	List<KanfangyuyueView> selectListView(Wrapper<KanfangyuyueEntity> wrapper);
   	
   	KanfangyuyueView selectView(@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KanfangyuyueEntity> wrapper);
   	

}


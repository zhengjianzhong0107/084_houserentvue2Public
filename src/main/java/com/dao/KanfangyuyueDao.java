package com.dao;

import com.entity.KanfangyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KanfangyuyueVO;
import com.entity.view.KanfangyuyueView;


/**
 * 看房预约
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface KanfangyuyueDao extends BaseMapper<KanfangyuyueEntity> {
	
	List<KanfangyuyueVO> selectListVO(@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);
	
	KanfangyuyueVO selectVO(@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);
	
	List<KanfangyuyueView> selectListView(@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);

	List<KanfangyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);
	
	KanfangyuyueView selectView(@Param("ew") Wrapper<KanfangyuyueEntity> wrapper);
	

}

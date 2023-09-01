package com.dao;

import com.entity.FangyuanchushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuanchushouVO;
import com.entity.view.FangyuanchushouView;


/**
 * 房源出售
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuanchushouDao extends BaseMapper<FangyuanchushouEntity> {
	
	List<FangyuanchushouVO> selectListVO(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
	
	FangyuanchushouVO selectVO(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
	
	List<FangyuanchushouView> selectListView(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);

	List<FangyuanchushouView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
	
	FangyuanchushouView selectView(@Param("ew") Wrapper<FangyuanchushouEntity> wrapper);
	

}

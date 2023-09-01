package com.dao;

import com.entity.FangyuangoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuangoumaiVO;
import com.entity.view.FangyuangoumaiView;


/**
 * 房源购买
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuangoumaiDao extends BaseMapper<FangyuangoumaiEntity> {
	
	List<FangyuangoumaiVO> selectListVO(@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);
	
	FangyuangoumaiVO selectVO(@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);
	
	List<FangyuangoumaiView> selectListView(@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);

	List<FangyuangoumaiView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);
	
	FangyuangoumaiView selectView(@Param("ew") Wrapper<FangyuangoumaiEntity> wrapper);
	

}

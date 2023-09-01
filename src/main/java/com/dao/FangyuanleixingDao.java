package com.dao;

import com.entity.FangyuanleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuanleixingVO;
import com.entity.view.FangyuanleixingView;


/**
 * 房源类型
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuanleixingDao extends BaseMapper<FangyuanleixingEntity> {
	
	List<FangyuanleixingVO> selectListVO(@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);
	
	FangyuanleixingVO selectVO(@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);
	
	List<FangyuanleixingView> selectListView(@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);

	List<FangyuanleixingView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);
	
	FangyuanleixingView selectView(@Param("ew") Wrapper<FangyuanleixingEntity> wrapper);
	

}

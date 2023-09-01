package com.dao;

import com.entity.FangyuanchuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangyuanchuzuVO;
import com.entity.view.FangyuanchuzuView;


/**
 * 房源出租
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface FangyuanchuzuDao extends BaseMapper<FangyuanchuzuEntity> {
	
	List<FangyuanchuzuVO> selectListVO(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
	
	FangyuanchuzuVO selectVO(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
	
	List<FangyuanchuzuView> selectListView(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);

	List<FangyuanchuzuView> selectListView(Pagination page,@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
	
	FangyuanchuzuView selectView(@Param("ew") Wrapper<FangyuanchuzuEntity> wrapper);
	

}

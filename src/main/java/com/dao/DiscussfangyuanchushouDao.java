package com.dao;

import com.entity.DiscussfangyuanchushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfangyuanchushouVO;
import com.entity.view.DiscussfangyuanchushouView;


/**
 * 房源出售评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:29
 */
public interface DiscussfangyuanchushouDao extends BaseMapper<DiscussfangyuanchushouEntity> {
	
	List<DiscussfangyuanchushouVO> selectListVO(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
	
	DiscussfangyuanchushouVO selectVO(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
	
	List<DiscussfangyuanchushouView> selectListView(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);

	List<DiscussfangyuanchushouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
	
	DiscussfangyuanchushouView selectView(@Param("ew") Wrapper<DiscussfangyuanchushouEntity> wrapper);
	

}

package com.dao;

import com.entity.DiscussfangyuanchuzuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussfangyuanchuzuVO;
import com.entity.view.DiscussfangyuanchuzuView;


/**
 * 房源出租评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:29
 */
public interface DiscussfangyuanchuzuDao extends BaseMapper<DiscussfangyuanchuzuEntity> {
	
	List<DiscussfangyuanchuzuVO> selectListVO(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
	
	DiscussfangyuanchuzuVO selectVO(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
	
	List<DiscussfangyuanchuzuView> selectListView(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);

	List<DiscussfangyuanchuzuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
	
	DiscussfangyuanchuzuView selectView(@Param("ew") Wrapper<DiscussfangyuanchuzuEntity> wrapper);
	

}

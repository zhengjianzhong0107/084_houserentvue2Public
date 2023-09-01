package com.dao;

import com.entity.JingjirenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingjirenVO;
import com.entity.view.JingjirenView;


/**
 * 经纪人
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface JingjirenDao extends BaseMapper<JingjirenEntity> {
	
	List<JingjirenVO> selectListVO(@Param("ew") Wrapper<JingjirenEntity> wrapper);
	
	JingjirenVO selectVO(@Param("ew") Wrapper<JingjirenEntity> wrapper);
	
	List<JingjirenView> selectListView(@Param("ew") Wrapper<JingjirenEntity> wrapper);

	List<JingjirenView> selectListView(Pagination page,@Param("ew") Wrapper<JingjirenEntity> wrapper);
	
	JingjirenView selectView(@Param("ew") Wrapper<JingjirenEntity> wrapper);
	

}

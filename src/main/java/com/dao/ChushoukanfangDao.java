package com.dao;

import com.entity.ChushoukanfangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChushoukanfangVO;
import com.entity.view.ChushoukanfangView;


/**
 * 出售看房
 * 
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface ChushoukanfangDao extends BaseMapper<ChushoukanfangEntity> {
	
	List<ChushoukanfangVO> selectListVO(@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);
	
	ChushoukanfangVO selectVO(@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);
	
	List<ChushoukanfangView> selectListView(@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);

	List<ChushoukanfangView> selectListView(Pagination page,@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);
	
	ChushoukanfangView selectView(@Param("ew") Wrapper<ChushoukanfangEntity> wrapper);
	

}

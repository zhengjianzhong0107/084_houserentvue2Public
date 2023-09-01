package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZufangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZufangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZufangxinxiView;


/**
 * 租房信息
 *
 * @author 
 * @email 
 * @date 2022-04-15 20:56:28
 */
public interface ZufangxinxiService extends IService<ZufangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZufangxinxiVO> selectListVO(Wrapper<ZufangxinxiEntity> wrapper);
   	
   	ZufangxinxiVO selectVO(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
   	
   	List<ZufangxinxiView> selectListView(Wrapper<ZufangxinxiEntity> wrapper);
   	
   	ZufangxinxiView selectView(@Param("ew") Wrapper<ZufangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZufangxinxiEntity> wrapper);
   	

}


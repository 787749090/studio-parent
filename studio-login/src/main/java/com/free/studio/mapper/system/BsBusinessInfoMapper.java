package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsBusinessInfo;
import com.free.studio.pojo.system.BsBusinessInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsBusinessInfoMapper {
    int countByExample(BsBusinessInfoExample example);

    int deleteByExample(BsBusinessInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsBusinessInfo record);

    int insertSelective(BsBusinessInfo record);

    List<BsBusinessInfo> selectByExample(BsBusinessInfoExample example);

    BsBusinessInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsBusinessInfo record, @Param("example") BsBusinessInfoExample example);

    int updateByExample(@Param("record") BsBusinessInfo record, @Param("example") BsBusinessInfoExample example);

    int updateByPrimaryKeySelective(BsBusinessInfo record);

    int updateByPrimaryKey(BsBusinessInfo record);
}
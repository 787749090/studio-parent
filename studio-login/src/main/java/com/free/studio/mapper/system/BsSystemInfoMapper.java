package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsSystemInfo;
import com.free.studio.pojo.system.BsSystemInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsSystemInfoMapper {
    int countByExample(BsSystemInfoExample example);

    int deleteByExample(BsSystemInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsSystemInfo record);

    int insertSelective(BsSystemInfo record);

    List<BsSystemInfo> selectByExample(BsSystemInfoExample example);

    BsSystemInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsSystemInfo record, @Param("example") BsSystemInfoExample example);

    int updateByExample(@Param("record") BsSystemInfo record, @Param("example") BsSystemInfoExample example);

    int updateByPrimaryKeySelective(BsSystemInfo record);

    int updateByPrimaryKey(BsSystemInfo record);
}
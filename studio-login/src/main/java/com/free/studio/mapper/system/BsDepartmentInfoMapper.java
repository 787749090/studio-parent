package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsDepartmentInfo;
import com.free.studio.pojo.system.BsDepartmentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsDepartmentInfoMapper {
    int countByExample(BsDepartmentInfoExample example);

    int deleteByExample(BsDepartmentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsDepartmentInfo record);

    int insertSelective(BsDepartmentInfo record);

    List<BsDepartmentInfo> selectByExample(BsDepartmentInfoExample example);

    BsDepartmentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsDepartmentInfo record, @Param("example") BsDepartmentInfoExample example);

    int updateByExample(@Param("record") BsDepartmentInfo record, @Param("example") BsDepartmentInfoExample example);

    int updateByPrimaryKeySelective(BsDepartmentInfo record);

    int updateByPrimaryKey(BsDepartmentInfo record);
}
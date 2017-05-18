package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsSystemMenu;
import com.free.studio.pojo.system.BsSystemMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsSystemMenuMapper {
    int countByExample(BsSystemMenuExample example);

    int deleteByExample(BsSystemMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsSystemMenu record);

    int insertSelective(BsSystemMenu record);

    List<BsSystemMenu> selectByExample(BsSystemMenuExample example);

    BsSystemMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsSystemMenu record, @Param("example") BsSystemMenuExample example);

    int updateByExample(@Param("record") BsSystemMenu record, @Param("example") BsSystemMenuExample example);

    int updateByPrimaryKeySelective(BsSystemMenu record);

    int updateByPrimaryKey(BsSystemMenu record);
}
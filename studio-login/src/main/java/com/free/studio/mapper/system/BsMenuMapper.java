package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsMenu;
import com.free.studio.pojo.system.BsMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsMenuMapper {
    int countByExample(BsMenuExample example);

    int deleteByExample(BsMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsMenu record);

    int insertSelective(BsMenu record);

    List<BsMenu> selectByExample(BsMenuExample example);

    BsMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsMenu record, @Param("example") BsMenuExample example);

    int updateByExample(@Param("record") BsMenu record, @Param("example") BsMenuExample example);

    int updateByPrimaryKeySelective(BsMenu record);

    int updateByPrimaryKey(BsMenu record);
}
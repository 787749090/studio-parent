package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsRoleRpMenu;
import com.free.studio.pojo.system.BsRoleRpMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsRoleRpMenuMapper {
    int countByExample(BsRoleRpMenuExample example);

    int deleteByExample(BsRoleRpMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsRoleRpMenu record);

    int insertSelective(BsRoleRpMenu record);

    List<BsRoleRpMenu> selectByExample(BsRoleRpMenuExample example);

    BsRoleRpMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsRoleRpMenu record, @Param("example") BsRoleRpMenuExample example);

    int updateByExample(@Param("record") BsRoleRpMenu record, @Param("example") BsRoleRpMenuExample example);

    int updateByPrimaryKeySelective(BsRoleRpMenu record);

    int updateByPrimaryKey(BsRoleRpMenu record);
}
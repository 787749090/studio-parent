package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsGroupRpRole;
import com.free.studio.pojo.system.BsGroupRpRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsGroupRpRoleMapper {
    int countByExample(BsGroupRpRoleExample example);

    int deleteByExample(BsGroupRpRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsGroupRpRole record);

    int insertSelective(BsGroupRpRole record);

    List<BsGroupRpRole> selectByExample(BsGroupRpRoleExample example);

    BsGroupRpRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsGroupRpRole record, @Param("example") BsGroupRpRoleExample example);

    int updateByExample(@Param("record") BsGroupRpRole record, @Param("example") BsGroupRpRoleExample example);

    int updateByPrimaryKeySelective(BsGroupRpRole record);

    int updateByPrimaryKey(BsGroupRpRole record);
}
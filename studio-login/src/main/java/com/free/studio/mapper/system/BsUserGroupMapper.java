package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsUserGroup;
import com.free.studio.pojo.system.BsUserGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsUserGroupMapper {
    int countByExample(BsUserGroupExample example);

    int deleteByExample(BsUserGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsUserGroup record);

    int insertSelective(BsUserGroup record);

    List<BsUserGroup> selectByExample(BsUserGroupExample example);

    BsUserGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsUserGroup record, @Param("example") BsUserGroupExample example);

    int updateByExample(@Param("record") BsUserGroup record, @Param("example") BsUserGroupExample example);

    int updateByPrimaryKeySelective(BsUserGroup record);

    int updateByPrimaryKey(BsUserGroup record);
}
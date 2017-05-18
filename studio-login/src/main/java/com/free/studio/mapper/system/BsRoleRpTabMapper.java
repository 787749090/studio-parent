package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsRoleRpTab;
import com.free.studio.pojo.system.BsRoleRpTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsRoleRpTabMapper {
    int countByExample(BsRoleRpTabExample example);

    int deleteByExample(BsRoleRpTabExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsRoleRpTab record);

    int insertSelective(BsRoleRpTab record);

    List<BsRoleRpTab> selectByExample(BsRoleRpTabExample example);

    BsRoleRpTab selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsRoleRpTab record, @Param("example") BsRoleRpTabExample example);

    int updateByExample(@Param("record") BsRoleRpTab record, @Param("example") BsRoleRpTabExample example);

    int updateByPrimaryKeySelective(BsRoleRpTab record);

    int updateByPrimaryKey(BsRoleRpTab record);
}
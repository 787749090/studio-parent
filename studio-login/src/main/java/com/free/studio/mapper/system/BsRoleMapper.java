package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsRole;
import com.free.studio.pojo.system.BsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsRoleMapper {
    int countByExample(BsRoleExample example);

    int deleteByExample(BsRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsRole record);

    int insertSelective(BsRole record);

    List<BsRole> selectByExample(BsRoleExample example);

    BsRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsRole record, @Param("example") BsRoleExample example);

    int updateByExample(@Param("record") BsRole record, @Param("example") BsRoleExample example);

    int updateByPrimaryKeySelective(BsRole record);

    int updateByPrimaryKey(BsRole record);
}
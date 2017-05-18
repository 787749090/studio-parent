package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsRoleRpButton;
import com.free.studio.pojo.system.BsRoleRpButtonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsRoleRpButtonMapper {
    int countByExample(BsRoleRpButtonExample example);

    int deleteByExample(BsRoleRpButtonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsRoleRpButton record);

    int insertSelective(BsRoleRpButton record);

    List<BsRoleRpButton> selectByExample(BsRoleRpButtonExample example);

    BsRoleRpButton selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsRoleRpButton record, @Param("example") BsRoleRpButtonExample example);

    int updateByExample(@Param("record") BsRoleRpButton record, @Param("example") BsRoleRpButtonExample example);

    int updateByPrimaryKeySelective(BsRoleRpButton record);

    int updateByPrimaryKey(BsRoleRpButton record);
}
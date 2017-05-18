package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsTab;
import com.free.studio.pojo.system.BsTabExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsTabMapper {
    int countByExample(BsTabExample example);

    int deleteByExample(BsTabExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsTab record);

    int insertSelective(BsTab record);

    List<BsTab> selectByExample(BsTabExample example);

    BsTab selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsTab record, @Param("example") BsTabExample example);

    int updateByExample(@Param("record") BsTab record, @Param("example") BsTabExample example);

    int updateByPrimaryKeySelective(BsTab record);

    int updateByPrimaryKey(BsTab record);
}
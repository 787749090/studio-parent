package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsButton;
import com.free.studio.pojo.system.BsButtonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsButtonMapper {
    int countByExample(BsButtonExample example);

    int deleteByExample(BsButtonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsButton record);

    int insertSelective(BsButton record);

    List<BsButton> selectByExample(BsButtonExample example);

    BsButton selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsButton record, @Param("example") BsButtonExample example);

    int updateByExample(@Param("record") BsButton record, @Param("example") BsButtonExample example);

    int updateByPrimaryKeySelective(BsButton record);

    int updateByPrimaryKey(BsButton record);
}
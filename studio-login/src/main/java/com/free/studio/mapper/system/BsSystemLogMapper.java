package com.free.studio.mapper.system;

import com.free.studio.pojo.system.BsSystemLog;
import com.free.studio.pojo.system.BsSystemLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BsSystemLogMapper {
    int countByExample(BsSystemLogExample example);

    int deleteByExample(BsSystemLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BsSystemLog record);

    int insertSelective(BsSystemLog record);

    List<BsSystemLog> selectByExample(BsSystemLogExample example);

    BsSystemLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BsSystemLog record, @Param("example") BsSystemLogExample example);

    int updateByExample(@Param("record") BsSystemLog record, @Param("example") BsSystemLogExample example);

    int updateByPrimaryKeySelective(BsSystemLog record);

    int updateByPrimaryKey(BsSystemLog record);
}
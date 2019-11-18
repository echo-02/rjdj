package com.accp.mapper;

import com.accp.domain.Goodspic;
import com.accp.domain.GoodspicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodspicMapper {
    int countByExample(GoodspicExample example);

    int deleteByExample(GoodspicExample example);

    int deleteByPrimaryKey(Integer gpid);

    int insert(Goodspic record);

    int insertSelective(Goodspic record);

    List<Goodspic> selectByExample(GoodspicExample example);

    Goodspic selectByPrimaryKey(Integer gpid);

    int updateByExampleSelective(@Param("record") Goodspic record, @Param("example") GoodspicExample example);

    int updateByExample(@Param("record") Goodspic record, @Param("example") GoodspicExample example);

    int updateByPrimaryKeySelective(Goodspic record);

    int updateByPrimaryKey(Goodspic record);
}
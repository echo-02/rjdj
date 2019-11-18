package com.accp.mapper;

import com.accp.domain.Recordinstance;
import com.accp.domain.RecordinstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordinstanceMapper {
    int countByExample(RecordinstanceExample example);

    int deleteByExample(RecordinstanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recordinstance record);

    int insertSelective(Recordinstance record);

    List<Recordinstance> selectByExample(RecordinstanceExample example);

    Recordinstance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recordinstance record, @Param("example") RecordinstanceExample example);

    int updateByExample(@Param("record") Recordinstance record, @Param("example") RecordinstanceExample example);

    int updateByPrimaryKeySelective(Recordinstance record);

    int updateByPrimaryKey(Recordinstance record);
}
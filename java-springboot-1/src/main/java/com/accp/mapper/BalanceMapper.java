package com.accp.mapper;

import com.accp.domain.Balance;
import com.accp.domain.BalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceMapper {
    int countByExample(BalanceExample example);

    int deleteByExample(BalanceExample example);

    int insert(Balance record);

    int insertSelective(Balance record);

    List<Balance> selectByExample(BalanceExample example);

    int updateByExampleSelective(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByExample(@Param("record") Balance record, @Param("example") BalanceExample example);
}
package com.accp.mapper;

import com.accp.domain.Record;
import com.accp.domain.Vip;
import com.accp.domain.VipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VipMapper {
    int countByExample(VipExample example);

    int deleteByExample(VipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Vip record);

    int insertSelective(Vip record);

    List<Vip> selectByExample(VipExample example);

    Vip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Vip record, @Param("example") VipExample example);

    int updateByExample(@Param("record") Vip record, @Param("example") VipExample example);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);

	Record selectVipMandC(int id);
}
package com.accp.mapper;

import com.accp.domain.Position;
import com.accp.domain.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer positionid);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer positionid);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    @Select("select * from `position` where `positionname`=#{positionname}")
    Position queryPositionName(String positionname);
    @Select("SELECT * FROM `jurisdictionset` a JOIN `position` b ON b.`positionid`=a.`positionid` WHERE a.positionid=#{positionid}")
    List<Position> by(Integer positionid);
   
}
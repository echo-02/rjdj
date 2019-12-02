package com.accp.mapper;

import com.accp.domain.Jurisdiction;
import com.accp.domain.JurisdictionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface JurisdictionMapper {
	List<Jurisdiction> findJurisdictionByParentId(@Param("parentId")Integer parentId,@Param("catalog")Integer catalog);
	
    List<Jurisdiction> findJurisdictionByPositionId(Integer positionid);
	
    int countByExample(JurisdictionExample example);

    int deleteByExample(JurisdictionExample example);

    int deleteByPrimaryKey(Integer jsid);

    int insert(Jurisdiction record);

    int insertSelective(Jurisdiction record);

    List<Jurisdiction> selectByExample(JurisdictionExample example);

    Jurisdiction selectByPrimaryKey(Integer jsid);

    int updateByExampleSelective(@Param("record") Jurisdiction record, @Param("example") JurisdictionExample example);

    int updateByExample(@Param("record") Jurisdiction record, @Param("example") JurisdictionExample example);

    int updateByPrimaryKeySelective(Jurisdiction record);

    int updateByPrimaryKey(Jurisdiction record);
    @Select("SELECT j.* FROM `jurisdiction` j\n" + 
    		"INNER JOIN `jurisdictionset` js ON j.`jsid`=js.`jsid`\n" + 
    		"INNER JOIN `position` p ON js.`positionid`=p.`positionid`\n" + 
    		"WHERE js.`positionid`=#{positionid}")
    List<Jurisdiction> queryii(Integer positionid);
}
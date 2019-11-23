package com.accp.mapper;

import com.accp.domain.Employee;
import com.accp.domain.EmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer emid);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer emid);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    @Select("SELECT s.`shopname`,p.`positionname`,e.*,u.`username`,u.`password` FROM \n" + 
    		"`shop` s,`position` p,`user` u,`employee` e\n" + 
    		"WHERE u.`userid`=s.`userid` AND e.`positionid`=p.`positionid` \n" + 
    		"AND s.`shopid`=e.`shopid`")
    List<Employee> queryAllStaff();
    
    @Select("SELECT s.`shopname`,p.`positionname`,e.*,u.`username`,u.`password` FROM \n" + 
    		"`shop` s,`position` p,`user` u,`employee` e\n" + 
    		"WHERE u.`userid`=s.`userid` AND e.`positionid`=p.`positionid` \n" + 
    		"AND s.`shopid`=e.`shopid` AND e.`emid`=#{emid}")
    Employee byEmid(Integer emid);
    
    @Select("SELECT s.`shopname`,p.`positionname`,e.*,u.`username`,u.`password` FROM \n" + 
    		"`shop` s,`position` p,`user` u,`employee` e\n" + 
    		"WHERE u.`userid`=s.`userid` AND e.`positionid`=p.`positionid`\n" + 
    		"AND s.`shopid`=e.`shopid` AND e.`shopid`=#{shopid}")
    List<Employee> byShopQuery(Integer shopid);
    
    @Select("SELECT s.`shopname`,p.`positionname`,e.*,u.`username`,u.`password` FROM \n" + 
    		"`shop` s,`position` p,`user` u,`employee` e\n" + 
    		"WHERE u.`userid`=s.`userid` AND e.`positionid`=p.`positionid`\n" + 
    		"AND s.`shopid`=e.`shopid` AND  p.`positionid`=#{positionid}")
    List<Employee> byPositionQuery(Integer positionid);
    
    @Delete("delete from `employee` where `jobnum`=#{jobnum}")
    int removePosition(String jobnum);
    
    @Select("SELECT * FROM `employee` WHERE `jobnum`=#{jobnum}")
    Employee queryJobnum(String jobnum);
}
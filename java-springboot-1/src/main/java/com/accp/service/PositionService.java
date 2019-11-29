package com.accp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Jurisdiction;
import com.accp.domain.Jurisdictionset;
import com.accp.domain.Position;
import com.accp.mapper.JurisdictionMapper;
import com.accp.mapper.JurisdictionsetMapper;
import com.accp.mapper.PositionMapper;

@Service
@Transactional
public class PositionService {
   @Autowired
   PositionMapper pm;
   @Autowired
   JurisdictionMapper jm;
   @Autowired
   JurisdictionsetMapper jsm;
   
   public List<Position> queryAllPosition(){
	   return pm.selectByExample(null);
   }
   
   public int addPosition(String ppname,String[] checked) {
	   int i=0;
	   Position p=new Position();
	   p.setPositionname(ppname);
	   pm.insertSelective(p);
	   for (String jsid : checked) {
		   Jurisdictionset jurisdictionset=new Jurisdictionset();
		   jurisdictionset.setPositionid(p.getPositionid());
		   jurisdictionset.setJsid(Integer.parseInt(jsid));
		   jsm.insertSelective(jurisdictionset);
	   }
	   return i;
	   
   }
   
   
   public int updatePosition(String positionid,String positionname,String[] checked) {
	   int i=0;
	   Position p=new Position();
	   p.setPositionid(Integer.parseInt(positionid));
	   p.setPositionname(positionname);
	   pm.updateByPrimaryKeySelective(p);
	   jsm.deletePositionid(Integer.parseInt(positionid));
	   for (String jsid : checked) {
		   Jurisdictionset jurisdictionset=new Jurisdictionset();
		   jurisdictionset.setPositionid(p.getPositionid());
		   jurisdictionset.setJsid(Integer.parseInt(jsid));
		   jsm.insertSelective(jurisdictionset);
	   }
	   return i;   
   }
   
   public int insert(Position p) {
	   return pm.insert(p);
   }
   
   public int insertpa(Jurisdictionset js) {
	   return jsm.insert(js);
   }
   
   public Position byPositionId(Integer positionid) {
	  return pm.selectByPrimaryKey(positionid);
   }
   
   public List<Jurisdictionset> byJurisdictionset(Integer positionid) {
	   return jsm.by(positionid);
   }
   
   public int delPosition(Integer positionid) {
	   return pm.deleteByPrimaryKey(positionid);
   }
   
   public Position queryPositionName(String positionname) {
	   return pm.queryPositionName(positionname);
   }
   
   public List<Jurisdiction> findJurisdictionByParentId(Integer parentId,Integer catalog){
	   return jm.findJurisdictionByParentId(parentId, catalog);
   }
   
   /**
	 * 根据用户编号获取模块-有层级的
	 * @param userid
	 * @return
	 */
   public List<Jurisdiction> findJurisdictionByPositionId(Integer positionid){
	   List<Jurisdiction> jlist=jm.findJurisdictionByPositionId(positionid);
	   Jurisdiction j=new Jurisdiction();
	   j.setJsid(0);
	   j.setJsname("顶层分类");
	   eachJurisdiction(jlist, j);
	   return j.getJus();
   }
   
   /**
	 * 根据用户编号获取模块-没有层级
	 * @param userid
	 * @return
	 */
	public List<Jurisdiction> findJurisdictionListByPositionId(Integer positionid){
		List<Jurisdiction> jlist = jm.findJurisdictionByPositionId(positionid);
		return jlist;
	}
   
    private void eachJurisdiction(List<Jurisdiction> jlist, Jurisdiction jur) {
	   for(Jurisdiction js:jlist) {
		   if(jur !=null && jur.getJsid()==js.getParentid()) {
			    Jurisdiction newJurisdiction = new Jurisdiction();
			    newJurisdiction.setJsid(js.getJsid());
			    newJurisdiction.setJsname(js.getJsname());
			    newJurisdiction.setCatalog(js.getCatalog());
			    newJurisdiction.setEnname(js.getEnname());
			    newJurisdiction.setParentid(js.getParentid());
			    newJurisdiction.setPath(js.getPath());
				jur.getJus().add(newJurisdiction);
				eachJurisdiction(jlist, newJurisdiction);
		   }
	   }
    }
   

}

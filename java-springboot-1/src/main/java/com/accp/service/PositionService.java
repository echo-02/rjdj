package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Position;
import com.accp.mapper.PositionMapper;

@Service
@Transactional
public class PositionService {
   @Autowired
   PositionMapper pm;
   
   public List<Position> queryAllPosition(){
	   return pm.selectByExample(null);
   }
}

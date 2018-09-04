package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.County;

public interface CountyDao {
	
	List<County> getCountyByCity(String cityId);
	

}

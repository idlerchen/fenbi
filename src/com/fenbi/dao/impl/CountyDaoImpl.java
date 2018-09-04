package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.County;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CountyDao;

public class CountyDaoImpl extends BaseDao<County> implements CountyDao {

	@Override
	public List<County> getCountyByCity(String cityId) {
		String sql = "select county_id countyId,name ctname,city_id cityId from fb_county where city_id=?";
		return this.getBeanList(sql, cityId);
	}

}

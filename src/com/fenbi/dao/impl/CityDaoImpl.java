package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.City;
import com.fenbi.dao.BaseDao;
import com.fenbi.dao.CityDao;

public class CityDaoImpl extends BaseDao<City> implements CityDao {

	@Override
	public List<City> getCityByP(String provinceId) {
		String sql = "SELECT fc.city_id Id,fc.name cname,fc.province_id provinceId " + 
				"FROM fb_city fc " + 
				"WHERE fc.province_id=?";
		return this.getBeanList(sql, provinceId);
	}

}

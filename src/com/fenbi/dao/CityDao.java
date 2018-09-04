package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.City;

public interface CityDao {

	List<City> getCityByP(String provinceId);
}

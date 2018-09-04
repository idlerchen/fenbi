package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.City;
import com.fenbi.dao.CityDao;
import com.fenbi.dao.impl.CityDaoImpl;

class TestCityD {

	@Test
	void testGetCityByP() {
		CityDao dao = new CityDaoImpl();
		List<City> c = dao.getCityByP("110000");
		
		for(City cc:c) {
			System.out.println(cc);
		}
		
		
	}

}

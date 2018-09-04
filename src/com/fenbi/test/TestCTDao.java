package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.County;
import com.fenbi.dao.CountyDao;
import com.fenbi.dao.impl.CountyDaoImpl;

class TestCTDao {

	@Test
	void testGetCountyByCity() {
		CountyDao dao = new CountyDaoImpl();
		List<County> countyByCity = dao.getCountyByCity("110100");
		for(County c:countyByCity) {
			System.out.println(c);
		}
	}

}

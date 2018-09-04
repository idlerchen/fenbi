package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fenbi.bean.Province;
import com.fenbi.dao.ProvinceDao;
import com.fenbi.dao.impl.ProvinceDaoImpl;

class TestPD {

	@Test
	void testGetProvince() {
		
		ProvinceDao dao = new ProvinceDaoImpl();
		List<Province> province = dao.getProvince();
		for(Province p:province) {
			System.out.println(p);
		}
	}

}

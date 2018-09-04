package com.fenbi.test;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.fenbi.bean.Address;
import com.fenbi.dao.AddressDao;

import com.fenbi.dao.impl.AddressDaoImpl;

class TestAddress {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAddressByUserId() {
		AddressDao dao = new AddressDaoImpl();
		List<Address> addressByUserId = dao.getAddressByUserId(22);
		for(Address a:addressByUserId) {
			System.out.println(a);
		}
	}

}

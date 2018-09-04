package com.fenbi.service.impl;

import java.util.List;

import com.fenbi.bean.Address;
import com.fenbi.bean.City;
import com.fenbi.bean.County;
import com.fenbi.bean.Province;
import com.fenbi.dao.AddressDao;
import com.fenbi.dao.CityDao;
import com.fenbi.dao.CountyDao;
import com.fenbi.dao.ProvinceDao;
import com.fenbi.dao.impl.AddressDaoImpl;
import com.fenbi.dao.impl.CityDaoImpl;
import com.fenbi.dao.impl.CountyDaoImpl;
import com.fenbi.dao.impl.ProvinceDaoImpl;
import com.fenbi.service.AddressService;

public class AddressServiceImpl implements AddressService {
	AddressDao dao = new AddressDaoImpl();
	@Override
	public Address getDefaultAddress(int userId) {
		return dao.getDefaultAddress(userId);
	}
	
	@Override
	public List<Province> getProvince() {
		ProvinceDao dao = new ProvinceDaoImpl();
		return dao.getProvince();
	}

	@Override
	public List<City> getCityByProvinceId(String provinceId) {
		CityDao citydao = new CityDaoImpl();
		return citydao.getCityByP(provinceId);
	}

	@Override
	public List<County> getCountyByCityId(String cityId) {
		CountyDao countydao = new CountyDaoImpl();
		return countydao.getCountyByCity(cityId);
	}

	@Override
	public boolean saveAddress(Address address) {
		
		return dao.saveAddress(address) > 0;
	}

	@Override
	public List<Address> getAddressByUserId(int userId) {
		
		return dao.getAddressByUserId(userId);
	}

	@Override
	public int updateY2N(int userId) {
		return dao.updateY2N(userId);
	}

	@Override
	public int updateN2Y(int userId, String addressId) {
		
		return dao.updateN2Y(userId, addressId);
	}

	@Override
	public int deleteAddress(String addressId) {
		
		return dao.deleteAddress(addressId);
	}

	@Override
	public int alterAddress(Address address) {

		return dao.alterAddress(address);
	}

	@Override
	public Address getAddressByAddressId(String addressId) {
		
		return dao.getAddressByAddressId(addressId);
	}

}

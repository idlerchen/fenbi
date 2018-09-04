package com.fenbi.service;

import java.util.List;

import com.fenbi.bean.Address;
import com.fenbi.bean.City;
import com.fenbi.bean.County;
import com.fenbi.bean.Province;

public interface AddressService {

	Address getDefaultAddress(int userId);
	
	List<Province> getProvince();
	
	List<City> getCityByProvinceId(String provinceId);
	
	List<County> getCountyByCityId(String cityId);
	
	boolean saveAddress(Address address);
	
	List<Address> getAddressByUserId(int userId);
	
	int updateY2N(int userId);
	
	int updateN2Y(int userId,String addressId);
	
	int deleteAddress(String addressId);
	
	int alterAddress(Address address);
	
	Address getAddressByAddressId(String addressId);

}

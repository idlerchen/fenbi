package com.fenbi.dao.impl;

import java.util.List;

import com.fenbi.bean.Address;
import com.fenbi.dao.AddressDao;
import com.fenbi.dao.BaseDao;

public class AddressDaoImpl extends BaseDao<Address> implements AddressDao {

	@Override
	public Address getDefaultAddress(int userId) {
		String sql="SELECT fa.id id,fa.user_id userId,fa.receiver receiver,fa.province_id provinceId,fa.city_id cityId,fa.county_id countyId," + 
				"fa.address address,fa.mobile_phone mobilePhone,fa.telephone telephone,fa.is_default isDefault,fa.create_time createTime,fp.name provinceName," + 
				"fc.name cityName,fct.name countyName " + 
				"FROM fb_address fa,fb_city fc,fb_county fct,fb_province fp " + 
				"WHERE fa.province_id=fp.province_id AND fa.city_id=fc.city_id AND fa.county_id=fct.county_id " + 
				"AND is_default='Y' AND user_id=?;";
		return this.getBean(sql, userId);
	}

	@Override
	public int saveAddress(Address address) {
		String sql = "INSERT INTO fb_address(user_id,receiver,province_id,city_id,county_id,address,telephone,is_default,create_time)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?,NOW());";
		return this.update(sql, address.getUserId(),address.getReceiver(),address.getProvinceId(),address.getCityId(),
				address.getCountyId(),address.getAddress(),address.getTelephone(),address.getIsDefault());
	}

	@Override
	public List<Address> getAddressByUserId(int userId) {
		String sql="SELECT fa.id id,fa.user_id userId,fa.receiver receiver,fa.province_id provinceId,fa.city_id cityId,fa.county_id countyId," + 
				"fa.address address,fa.mobile_phone mobilePhone,fa.telephone telephone,fa.is_default isDefault,fa.create_time createTime,fp.name provinceName," + 
				"fc.name cityName,fct.name countyName " + 
				"FROM fb_address fa,fb_city fc,fb_county fct,fb_province fp " + 
				"WHERE fa.province_id=fp.province_id AND fa.city_id=fc.city_id AND fa.county_id=fct.county_id " + 
				"AND user_id=? order by fa.create_time desc";
		return this.getBeanList(sql, userId);
	}

	@Override
	public int updateY2N(int userId) {
		String sql = "UPDATE fb_address SET is_default = 'N' WHERE user_id=?";
		return this.update(sql, userId);
	}

	@Override
	public int updateN2Y(int userId,String addressId) {
		String sql = "UPDATE fb_address SET is_default = 'Y' WHERE user_id=? AND id=?";
		return this.update(sql, userId,addressId);
	}

	@Override
	public int deleteAddress(String addressId) {
		String sql = "DELETE FROM fb_address WHERE id=?";
		return this.update(sql, addressId);
	}

	@Override
	public int alterAddress(Address address) {
		String sql="UPDATE fb_address SET receiver=?,province_id=?,city_id=?,county_id=?,address=?,telephone=? WHERE id=?";
		return this.update(sql, address.getReceiver(),address.getProvinceId(),address.getCityId(),address.getCountyId(),address.getAddress(),address.getTelephone(),address.getId());
	}

	@Override
	public Address getAddressByAddressId(String addressId) {
		String sql="SELECT fa.id id,fa.user_id userId,fa.receiver receiver,fa.province_id provinceId,fa.city_id cityId,fa.county_id countyId," + 
				"fa.address address,fa.mobile_phone mobilePhone,fa.telephone telephone,fa.is_default isDefault,fa.create_time createTime,fp.name provinceName," + 
				"fc.name cityName,fct.name countyName " + 
				"FROM fb_address fa,fb_city fc,fb_county fct,fb_province fp " + 
				"WHERE fa.province_id=fp.province_id AND fa.city_id=fc.city_id AND fa.county_id=fct.county_id " + 
				"AND fa.id=?";
		return this.getBean(sql, addressId);
	}

}

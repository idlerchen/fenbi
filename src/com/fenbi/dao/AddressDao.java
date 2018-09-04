package com.fenbi.dao;

import java.util.List;

import com.fenbi.bean.Address;

public interface AddressDao {
	//立即购买进入订单后获取默认定制
	Address getDefaultAddress(int userId);
	
	//插入地址，在进入订单无地址时插入，以及修改地址时增加地址
	int saveAddress(Address address);
	
//	/修改地址时获取用户的所有地址
	List<Address> getAddressByUserId(int userId);
	
	//设为默认地址时，先将原地址设为N，在将次地址设为Y
	int updateY2N(int userId);
	int updateN2Y(int userId,String addressId);
	
	//删除地址
	int deleteAddress(String addressId);
	
	//修改地址中各个值
	int alterAddress(Address address);
	
	Address getAddressByAddressId(String addressId);
	

}

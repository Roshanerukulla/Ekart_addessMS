package service;

import entity.AddressEntity;

public interface AddressService {

	public String addAddress(AddressEntity address, int userId);
	public AddressEntity getAddressById(int id);
	public String modifyAddress(AddressEntity address);
	public String deleteAddress(int addressId);
}

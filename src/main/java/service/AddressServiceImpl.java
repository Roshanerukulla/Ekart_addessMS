package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.AddressEntity;
import repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public String addAddress(AddressEntity address, int userId) {
		// TODO Auto-generated method stub
		address.setUser_id(userId);
		int userAddressPresent = this.addressRepo.countByUserId(userId); 
		
		if(userAddressPresent==0) {
			String pincode = address.getPincode();
			// Length of pincode should be 6
			if(pincode.length()!=6) {
				return "Please give 6 digits in Pin Code";
			}
			List<String> stateList = List.of("punjab","haryana","himachal pradesh","sikkim","Nagaland","maharashtra",
					"telangana","uttar pradesh","tamil nadu","kerala","west bengal","odisha","arunachal pradesh",
					"gujarat","rajasthan","bihar","karnataka","tripura","chattisgarh","jharkhand");
			
			//check state is from 29 different state or not
			String s = address.getState();
			boolean flag = stateList.contains(s);
			
			if(flag==false){
				return "Please give 6 digits in Pin Code";
			}
			
			String phoneNumber = address.getPhoneNumber();
			if(phoneNumber.length()!=10)
				return "Please enter 10 digits Phone Number";
						
			this.addressRepo.save(address);
			return "Successfully Added Address";
			
		}else {
			return "User Already Exist";
		}
	}

	@Override
	public AddressEntity getAddressById(int id) {
		// TODO Auto-generated method stub
			return this.addressRepo.getByAdressId(id);
	}

	@Override
	public String modifyAddress(AddressEntity address) {
		// TODO Auto-generated method stub
		String pincode = address.getPincode();
		// Length of pincode should be 6
		if(pincode.length()!=6) {
			return "Please give 6 digits in Pin Code";
		}
		List<String> stateList = List.of("punjab","haryana","himachal pradesh","sikkim","Nagaland","maharashtra",
				"telangana","uttar pradesh","tamil nadu","kerala","west bengal","odisha","arunachal pradesh",
				"gujarat","rajasthan","bihar","karnataka","tripura","chattisgarh","jharkhand");
		
		//check state is from 29 different state or not
		String s = address.getState();
		boolean flag = stateList.contains(s);
		
		if(flag==false){
			return "Please give 6 digits in Pin Code";
		}
		
		String phoneNumber = address.getPhoneNumber();
		if(phoneNumber.length()!=10)
			return "Please enter 10 digits Phone Number";
		this.addressRepo.save(address);
		
		return "address modified";
	}

	@Override
	public String deleteAddress(int addressId) {
		// TODO Auto-generated method stub
		this.addressRepo.deleteById(addressId);
		
		return "Address Deleted";
	}	
}

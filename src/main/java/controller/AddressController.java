package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.AddressEntity;
import service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	@PostMapping("/{userid}/address/add")
	public String addAddress(@RequestBody AddressEntity address, @PathVariable int userId) {
		return this.addressService.addAddress(address, userId);
	}
	
	@GetMapping("/{userid}/address/{addressid}")
	public AddressEntity getAllAddress(@PathVariable("userid") int userid, @PathVariable("addressid") int addressid) {
		return this.addressService.getAddressById(addressid);
	}

	@PostMapping("/{userid}/address/{addressid}/modify")
	public String modifyAddress(@RequestBody AddressEntity address, @PathVariable int userId,@PathVariable int addressid) {
		address.setAddressid(addressid);
		address.setUser_id(userId);
		address.setAddressid(addressid);
		
		return this.addressService.modifyAddress(address);
		
	}
	
	@GetMapping("/{userid}/address/{addressid}/delete")
	public String deleteAddress(@PathVariable("userid") int addressid) {
		return this.addressService.deleteAddress(addressid);
	}
}

package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="address")

public class AddressEntity {

		@Id
		@Column(name="")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int addressid;
		
		@Column(unique=true)
		private int user_id;
		
		private String address;
		
		private String city;
		private String state;
		private String pincode;
		private String phoneNumber;
		public int getAddressid() {
			return addressid;
		}
		public void setAddressid(int addressid) {
			this.addressid = addressid;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public AddressEntity(int addressid, int user_id, String address, String city, String state, String pincode,
				String phoneNumber) {
			super();
			this.addressid = addressid;
			this.user_id = user_id;
			this.address = address;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
			this.phoneNumber = phoneNumber;
		}
		public AddressEntity() {
			super();
		}
		
		
		
		
				
}

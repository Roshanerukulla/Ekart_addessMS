package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
	
		AddressEntity getByAdressId(int id);
		int countByUserId(int userid);
}

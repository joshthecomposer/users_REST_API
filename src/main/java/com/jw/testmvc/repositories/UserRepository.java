package com.jw.testmvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jw.testmvc.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	@Query(value = "SELECT * FROM users ORDER BY id", nativeQuery = true)
	List<User> getAllUsers();
	
}

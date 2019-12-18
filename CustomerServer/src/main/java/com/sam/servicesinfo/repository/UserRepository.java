package com.sam.servicesinfo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.servicesinfo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	User findByEmail(String email);
}

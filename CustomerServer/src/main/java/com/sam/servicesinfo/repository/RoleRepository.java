package com.sam.servicesinfo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.servicesinfo.domain.security.Role;

public interface RoleRepository  extends CrudRepository<Role, Long> {

	Role findByname(String name);
}

package com.vm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vm.api.model.Role;

@Repository
@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	
	
	
}

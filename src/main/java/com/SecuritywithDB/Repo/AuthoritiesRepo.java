package com.SecuritywithDB.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SecuritywithDB.MyEntity.Authorities;

public interface AuthoritiesRepo extends JpaRepository<Authorities, Integer> {
	
	

}

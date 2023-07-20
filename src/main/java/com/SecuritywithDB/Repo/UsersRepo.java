package com.SecuritywithDB.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SecuritywithDB.MyEntity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {
	
	

}

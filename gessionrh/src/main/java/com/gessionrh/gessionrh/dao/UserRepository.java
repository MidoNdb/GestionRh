package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}

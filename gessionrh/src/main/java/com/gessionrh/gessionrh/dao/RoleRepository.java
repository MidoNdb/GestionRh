package com.gessionrh.gessionrh.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findById(long id);
    Role findByName(String name);
}

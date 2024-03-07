package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gessionrh.gessionrh.entity.Permission;

public interface PermissionRepo extends JpaRepository<Permission,Long> {
    boolean existsByName(String name);
}



 package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer> {

    
}
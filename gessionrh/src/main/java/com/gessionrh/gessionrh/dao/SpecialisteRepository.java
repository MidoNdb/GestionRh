package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Specialite;
@Repository
public interface SpecialisteRepository extends JpaRepository<Specialite , Integer> {
    
}


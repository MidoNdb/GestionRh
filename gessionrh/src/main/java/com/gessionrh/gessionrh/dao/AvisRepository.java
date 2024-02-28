package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Avis;
@Repository
public interface AvisRepository extends JpaRepository<Avis,Integer> {
    
}

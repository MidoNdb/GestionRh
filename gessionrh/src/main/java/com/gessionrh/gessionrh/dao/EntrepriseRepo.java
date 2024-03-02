package com.gessionrh.gessionrh.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Entreprise;
import java.util.List;

@Repository
public interface EntrepriseRepo extends JpaRepository<Entreprise,Integer> {
    public  List<Entreprise> findByNom(String nom);

}
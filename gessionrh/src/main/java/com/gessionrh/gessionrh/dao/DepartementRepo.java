package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Departement;
import com.gessionrh.gessionrh.entity.Entreprise;

import java.util.List;


@Repository
public interface DepartementRepo extends JpaRepository<Departement,Integer> {
    public List<Departement> findByNom(String Nom);
    public List<Departement> findByDescription(String Description);
    public List<Departement> findByEntreprise(Entreprise entreprise);

}
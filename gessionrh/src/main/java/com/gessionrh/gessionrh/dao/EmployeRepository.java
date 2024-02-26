

package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Employé;
import java.util.List;
@Repository
public interface EmployeRepository extends JpaRepository<Employé,Integer> {
    public  List<Employé> findByNom(String nom);
    public List<Employé> findByPrénom(String prénom);
    public Employé findByEmail(String email);
    public List<Employé> findByNivauEtude(String nivauEtude);
}
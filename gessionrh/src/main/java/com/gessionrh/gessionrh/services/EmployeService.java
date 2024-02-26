package com.gessionrh.gessionrh.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gessionrh.gessionrh.dao.EmployeRepository;
import com.gessionrh.gessionrh.entity.Employé;

@Service
public class EmployeService {
    private EmployeRepository employeRepository;

    public ResponseEntity<Object> selectEmployes(){
        try {
            return ResponseEntity.ok().body(employeRepository.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertEmploye( Employé employé){
        try {
            employeRepository.save(employé);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateEmploye( Employé employé,Integer id){
        Optional<Employé> optEmp= employeRepository.findById(id);
        if(optEmp.isPresent()){
            Employé newE=optEmp.get();
            newE.setNom(employé.getNom());
            newE.setPrénom(employé.getPrénom());
            newE.setEmail(employé.getEmail());
            newE.setNivauEtude(employé.getNivauEtude());
            employeRepository.save(newE);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun employe de cet id ");
        }
    }
    public ResponseEntity<Object> deleteEmploye(Integer id){
        Optional<Employé> optEmploye= employeRepository.findById(id);
        if(optEmploye.isPresent()){
            employeRepository.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun employe de cet id ");
        }
    }
    
}

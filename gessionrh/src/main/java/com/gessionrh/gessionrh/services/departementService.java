package com.gessionrh.gessionrh.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gessionrh.gessionrh.dao.DepartementRepo;

import com.gessionrh.gessionrh.entity.Departement;


@Service
public class DepartementService {
    @Autowired
    private DepartementRepo departementRepo;

    public ResponseEntity<Object> selectDepartements(){
        try {
            return ResponseEntity.ok().body(departementRepo.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertDepartement(Departement departement){
        try {
            departementRepo.save(departement);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateDepartement( Departement departement,Integer code){
        Optional<Departement> optd= departementRepo.findById(code);
        if(optd.isPresent()){
            Departement newdp=optd.get();
            newdp.setDescription(departement.getDescription());
            newdp.setNom(departement.getNom());
            newdp.setEntreprise(departement.getEntreprise());
            departementRepo.save(newdp);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    public ResponseEntity<Object> deleteDepartement(Integer code){
        Optional<Departement> optdep= departementRepo.findById(code);
        if(optdep.isPresent()){
            departementRepo.deleteById(code);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun Departement de cet id ");
        }
    }
    
}

package com.gessionrh.gessionrh.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.gessionrh.gessionrh.dao.SpecialisteRepository;

import com.gessionrh.gessionrh.entity.Specialite;

@Service
public class SpecialisteService {
     private SpecialisteRepository sRepository;
    public ResponseEntity<Object> selectSpecialiste(){
        try {
            return ResponseEntity.ok().body(sRepository.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertSpecialiste(Specialite s){
        try {
           sRepository.save(s);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateSpecialiste( Specialite s,Integer id){
        Optional<Specialite> optionalS= sRepository.findById(id);
        if(optionalS.isPresent()){
            Specialite newSp=optionalS.get();
            newSp.setSpecialite(s.getSpecialite());
            sRepository.save(newSp);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    public ResponseEntity<Object> deleteSpecialiste(Integer id){
        Optional<Specialite> optSp= sRepository.findById(id);
        if(optSp.isPresent()){
            sRepository.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    
}

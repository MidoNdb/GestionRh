package com.gessionrh.gessionrh.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gessionrh.gessionrh.dao.EntrepriseRepo;

import com.gessionrh.gessionrh.entity.Entreprise;


@Service
public class EntrepriseService {
    @Autowired
    private EntrepriseRepo entrepriseRepo;

    public ResponseEntity<Object> selectEntreprises(){
        try {
            return ResponseEntity.ok().body(entrepriseRepo.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertEntreprise(Entreprise entreprise){
        try {
            entrepriseRepo.save(entreprise);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateEntreprise( Entreprise entreprise,Integer id){
        Optional<Entreprise> optEn= entrepriseRepo.findById(id);
        if(optEn.isPresent()){
            Entreprise newEn=optEn.get();
            newEn.setNom(entreprise.getNom());
          
            entrepriseRepo.save(newEn);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun entreprise de cet id ");
        }
    }
    public ResponseEntity<Object> deleteEntreprise(Integer id){
        Optional<Entreprise> optE= entrepriseRepo.findById(id);
        if(optE.isPresent()){
            entrepriseRepo.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun entreprise de cet id ");
        }
    }
    
}

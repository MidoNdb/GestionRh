package com.gessionrh.gessionrh.services;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.gessionrh.gessionrh.dao.AvisRepository;
import com.gessionrh.gessionrh.entity.Avis;

@Service
public class AvisService {
     private AvisRepository avisRepository;
    public ResponseEntity<Object> selectAvises(){
        try {
            return ResponseEntity.ok().body(avisRepository.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertAvis(Avis avis){
        try {
           avisRepository.save(avis);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateAvis( Avis avis,Integer id){
        Optional<Avis> optionalAvis= avisRepository.findById(id);
        if(optionalAvis.isPresent()){
            Avis newAvis=optionalAvis.get();
            newAvis.setAvis(avis.getAvis());
            avisRepository.save(newAvis);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    public ResponseEntity<Object> deleteAis(Integer id){
        Optional<Avis> optAvis= avisRepository.findById(id);
        if(optAvis.isPresent()){
            avisRepository.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    
}

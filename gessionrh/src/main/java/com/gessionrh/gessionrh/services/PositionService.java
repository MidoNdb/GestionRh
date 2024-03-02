package com.gessionrh.gessionrh.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gessionrh.gessionrh.dao.PositionRepository;
import com.gessionrh.gessionrh.entity.Position;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public ResponseEntity<Object> selectPotitions(){
        try {
            return ResponseEntity.ok().body(positionRepository.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertPosition (Position position){
        try {
            positionRepository.save(position);
            return ResponseEntity.ok().body("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updatePosition( Position position,Integer id){
        Optional<Position> optp= positionRepository.findById(id);
        if(optp.isPresent()){
            Position newp=optp.get();
            newp.setNomPasition(position.getNomPasition());
            newp.setSalaire(position.getSalaire());
            positionRepository.save(newp);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    public ResponseEntity<Object> deletePosition(Integer id){
        Optional<Position> optpostion= positionRepository.findById(id);
        if(optpostion.isPresent()){
            positionRepository.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    
}

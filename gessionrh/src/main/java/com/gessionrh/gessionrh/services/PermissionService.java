package com.gessionrh.gessionrh.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gessionrh.gessionrh.dao.PermissionRepo;
import com.gessionrh.gessionrh.entity.Permission;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepo repository;

    public ResponseEntity<Object> selectPermissions(){
        try {
            return ResponseEntity.ok().body(repository.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertPermission( Permission permission){
        try {
            repository.save(permission);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updatePermission( Permission permission,Long id){
        Optional<Permission> optPr = repository.findById(id);
        if(optPr.isPresent()){
            Permission newpr=optPr.get();
            newpr.setName(permission.getName());
            newpr.setUpdatedAt(permission.getUpdatedAt());
            newpr.setCreatedAt(permission.getCreatedAt());
            repository.save(newpr);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun permission de cet id ");
        }
    }
    public ResponseEntity<Object> deletePermission(long id){
        Optional<Permission> optp= repository.findById(id);
        if(optp.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun permission de cet id ");
        }
    }
    
}

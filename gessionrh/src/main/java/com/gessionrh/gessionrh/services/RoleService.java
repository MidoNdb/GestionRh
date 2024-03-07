package com.gessionrh.gessionrh.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.gessionrh.gessionrh.dao.RoleRepository;
import com.gessionrh.gessionrh.entity.Role;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepo;

    public ResponseEntity<Object> selectRoles(){
        try {
            return ResponseEntity.ok().body(roleRepo.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertRole(Role role){
        try {
            roleRepo.save(role);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateRole( Role role,Integer id){
        Optional<Role> optRole= roleRepo.findById(id);
        if(optRole.isPresent()){
            Role newRole=optRole.get();
            newRole.setName(role.getName());
            newRole.setPermissions(role.getPermissions());
            newRole.setCreatedAt(role.getCreatedAt());
            newRole.setUpdatedAt(role.getUpdatedAt());
            roleRepo.save(newRole);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun role de cet id ");
        }
    }
    public ResponseEntity<Object> deleteRole(Integer id){
        Optional<Role> optr= roleRepo.findById(id);
        if(optr.isPresent()){
            roleRepo.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun role de cet id ");
        }
    }
}

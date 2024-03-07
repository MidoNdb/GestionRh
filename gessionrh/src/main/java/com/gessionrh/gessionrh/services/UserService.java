package com.gessionrh.gessionrh.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.gessionrh.gessionrh.dao.UserRepository;
import com.gessionrh.gessionrh.entity.AppUser;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public ResponseEntity<Object> selectUsers(){
        try {
            return ResponseEntity.ok().body(userRepo.findAll()); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("null");
        }
    }

    public ResponseEntity<Object> insertUser(AppUser user){
        try {
            userRepo.save(user);
            return ResponseEntity.ok("ajoute avec success"); 
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("n'est pas ajouter");
        }
    }

    public ResponseEntity<Object> updateUser( AppUser user,Integer id){
        Optional<AppUser> optUser= userRepo.findById(id);
        if(optUser.isPresent()){
            AppUser newUser=optUser.get();
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setPhoneNumber(user.getPhoneNumber());
            newUser.setAddress(user.getAddress());
            newUser.setNni(user.getNni());
            newUser.setRole(user.getRole());
            newUser.setCreatedAt(newUser.getCreatedAt());
            newUser.setUpdatedAt(user.getUpdatedAt());
            userRepo.save(newUser);
            return ResponseEntity.ok("modifier avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
    public ResponseEntity<Object> deleteUser(Integer id){
        Optional<AppUser> optU= userRepo.findById(id);
        if(optU.isPresent()){
            userRepo.deleteById(id);
            return ResponseEntity.ok("suprimer avec success"); 
        } 
        else{
            return ResponseEntity.internalServerError().body("aucun position de cet id ");
        }
    }
}

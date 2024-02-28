package com.gessionrh.gessionrh.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    private String specialite;
    
}

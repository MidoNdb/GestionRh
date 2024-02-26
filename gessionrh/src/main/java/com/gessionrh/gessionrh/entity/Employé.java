package com.gessionrh.gessionrh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employé{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NonNull
    private String nom;
    @NonNull
    private String prénom;
    @Column(unique = true)
    private String email;
    private String nivauEtude ;   
}


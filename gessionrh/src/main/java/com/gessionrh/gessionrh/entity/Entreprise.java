package com.gessionrh.gessionrh.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entreprise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    private String nom;

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="entreprise")
    private Set<Employé> employés= new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="entreprise")
    private Set<Departement> departements= new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="entreprise")
    private Set<Avis> avis= new HashSet<>();
    
}

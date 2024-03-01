package com.gessionrh.gessionrh.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entreprise {



    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="entreprise")
    private Set<Employé> employés= new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="entreprise")
    private Set<Departement> departements= new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="entreprise")
    private Set<Avis> avis= new HashSet<>();
    
}

package com.gessionrh.gessionrh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    private String nom;
    @NonNull
    private String prénom;
    @Column(unique = true)
    private String email;
    private String nivauEtude ;  

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ePosition",referencedColumnName="id")
    private Position position;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="entreprise",referencedColumnName="id")
    private Entreprise entreprise;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="departement",referencedColumnName="code")
    private Departement departement;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="specialite",referencedColumnName="id")
    private Specialite specialite;
    
}


package com.gessionrh.gessionrh.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity  
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    private String nomPasition;
    private double salaire;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="departement",referencedColumnName="code")
    private Departement departement;

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="position")
    private Set<Employé> employés= new HashSet<>();

    
}

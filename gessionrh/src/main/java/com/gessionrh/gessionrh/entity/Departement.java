package com.gessionrh.gessionrh.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    private String nom;
    private String description;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="entreprise",referencedColumnName="id")
    private Entreprise entreprise;


    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="departement")
    private Set<Employé> employés= new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="departement")
    private Set<Position> positions= new HashSet<>();
}

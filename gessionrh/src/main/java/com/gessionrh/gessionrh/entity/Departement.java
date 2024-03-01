package com.gessionrh.gessionrh.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="entreprise",referencedColumnName="id")
    private Departement departement;


    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="departement")
    private Set<Employé> employés= new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL , fetch=FetchType.EAGER,mappedBy="departement")
    private Set<Position> positions= new HashSet<>();
}

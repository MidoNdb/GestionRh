package com.gessionrh.gessionrh.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Avis {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer id;
    private String avis;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="entreprise",referencedColumnName="id")
    private Entreprise entreprise;
     
}

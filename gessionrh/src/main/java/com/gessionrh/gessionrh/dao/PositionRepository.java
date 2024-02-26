package com.gessionrh.gessionrh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gessionrh.gessionrh.entity.Position;
import java.util.List;


@Repository
public interface PositionRepository extends JpaRepository<Position,Integer>{
    public Position findByNomPasition( String nomPosition);
    public List<Position> findBySalaire(double salaire);
}

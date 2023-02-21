package com.examen.alejandro.franco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.alejandro.franco.entity.RegisterCalculationEntity;

@Repository
public interface RequestCalculationRepository extends JpaRepository<RegisterCalculationEntity, Integer>{

}

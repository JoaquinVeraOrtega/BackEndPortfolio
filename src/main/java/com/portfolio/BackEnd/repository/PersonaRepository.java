
package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository <Persona, Integer> {
    
}
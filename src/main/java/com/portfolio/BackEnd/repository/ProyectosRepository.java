
package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectosRepository extends JpaRepository <Proyecto, Integer> {
    
}

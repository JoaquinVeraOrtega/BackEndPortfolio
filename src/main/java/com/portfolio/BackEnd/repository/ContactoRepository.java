
package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactoRepository extends JpaRepository <Contacto, Integer> {
    
}


package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository <Skill, Integer> {
    
}

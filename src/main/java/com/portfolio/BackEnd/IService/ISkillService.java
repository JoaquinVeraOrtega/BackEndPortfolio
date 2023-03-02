
package com.portfolio.BackEnd.IService;

import com.portfolio.BackEnd.model.Skill;
import java.util.List;


public interface ISkillService {
    
     public void agregarSkill (Skill skill);
    
    public void borrarSkill (int id);
    
    public Skill editarSkill (int id, Skill nuevaSkill);
    
    public Skill buscarSkill (int id);
    
    public List <Skill> mostrarSkills ();
    
}

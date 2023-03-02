
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.BackEnd.repository.SkillRepository;
import com.portfolio.BackEnd.IService.ISkillService;

@Service
public class SkillService implements ISkillService {
    
    @Autowired
    public SkillRepository skillRepo;
    
    
    @Override
    public void agregarSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void borrarSkill (int id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill (int id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public List<Skill> mostrarSkills () {
        return skillRepo.findAll();
    }

    @Override
    public Skill editarSkill(int id, Skill nuevaSkill) {
         Skill skill = skillRepo.findById(id).get();
        nuevaSkill.setId(skill.getId());
        return skillRepo.save(nuevaSkill);
    }
    
}

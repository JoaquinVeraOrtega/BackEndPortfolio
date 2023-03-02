
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.IService.IExperienciaService;
import com.portfolio.BackEnd.model.Experiencia;
import com.portfolio.BackEnd.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    
    @Autowired
    public ExperienciaRepository experienciaRepo;
    
    
    @Override
    public void agregarExperiencia(Experiencia expe) {
        experienciaRepo.save(expe);
    }

    @Override
    public void borrarExperiencia(int id) {
        experienciaRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(int id) {
        return experienciaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Experiencia> mostrarExperiencias() {
        return experienciaRepo.findAll();
    }

    @Override
    public Experiencia editarExperiencia(int id, Experiencia nuevaExperiencia) {
         Experiencia expe = experienciaRepo.findById(id).get();
        nuevaExperiencia.setId(expe.getId());
        return experienciaRepo.save(nuevaExperiencia);
    }
    
}

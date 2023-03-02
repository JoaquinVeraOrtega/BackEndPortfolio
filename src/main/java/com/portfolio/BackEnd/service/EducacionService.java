
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.IService.IEducacionService;
import com.portfolio.BackEnd.model.Educacion;
import com.portfolio.BackEnd.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    
    @Autowired
    public EducacionRepository educacionRepo;
    
    
    @Override
    public void agregarEducacion(Educacion educ) {
        educacionRepo.save(educ);
    }

    @Override
    public void borrarEducacion(int id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(int id) {
        return educacionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Educacion> mostrarEducacion() {
        return educacionRepo.findAll();
    }

    @Override
    public Educacion editarEducacion(int id, Educacion nuevaEducacion) {
         Educacion educacion = educacionRepo.findById(id).get();
        nuevaEducacion.setId(educacion.getId());
        return educacionRepo.save(nuevaEducacion);
    }
    
}


package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Proyecto;
import com.portfolio.BackEnd.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.BackEnd.IService.IProyectoService;

@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    public ProyectosRepository proyectoRepo;
    
    
    @Override
    public void agregarProyecto(Proyecto proyect) {
        proyectoRepo.save(proyect);
    }

    @Override
    public void borrarProyecto(int id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(int id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> mostrarProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto editarProyecto(int id, Proyecto nuevoProyecto) {
         Proyecto proyect = proyectoRepo.findById(id).get();
        nuevoProyecto.setId(proyect.getId());
        return proyectoRepo.save(nuevoProyecto);
    }
    
}

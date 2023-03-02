
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.IService.IPersonaService;
import com.portfolio.BackEnd.model.Persona;
import com.portfolio.BackEnd.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository personaRepo;
    
    
    @Override
    public void agregarPersona(Persona perso) {
        personaRepo.save(perso);
    }

    @Override
    public void borrarPersona(int id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(int id) {
        return personaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Persona> mostrarPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public Persona editarPersona(int id, Persona nuevaPersona) {
         Persona persona = personaRepo.findById(id).get();
        nuevaPersona.setId(persona.getId());
        return personaRepo.save(nuevaPersona);
    }

    
    
}

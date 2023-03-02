
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.IService.IContactoService;
import com.portfolio.BackEnd.model.Contacto;
import com.portfolio.BackEnd.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService implements IContactoService {
    
    @Autowired
    public ContactoRepository contactoRepo;
    
    
    @Override
    public void agregarContacto(Contacto contact) {
        contactoRepo.save(contact);
    }

    @Override
    public void borrarContacto(int id) {
        contactoRepo.deleteById(id);
    }

    @Override
    public Contacto buscarContacto(int id) {
        return contactoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Contacto> mostrarContacto() {
        return contactoRepo.findAll();
    }

    @Override
    public Contacto editarContacto(int id, Contacto nuevoContacto) {
         Contacto contacto = contactoRepo.findById(id).get();
        nuevoContacto.setId(contacto.getId());
        return contactoRepo.save(nuevoContacto);
    }
    
}

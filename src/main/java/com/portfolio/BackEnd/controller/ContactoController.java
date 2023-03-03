
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.IService.IContactoService;
import com.portfolio.BackEnd.model.Contacto;
import com.portfolio.BackEnd.security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "https://miportfolio-5dafe.web.app")
public class ContactoController {
    
    @Autowired
    private IContactoService contactServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/contacto/agregar")
    public void agregarContacto (@RequestBody Contacto contact){
        contactServ.agregarContacto(contact);
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/contacto/borrar/{id}")
    public void borrarContacto (@PathVariable int id) {
        contactServ.borrarContacto(id);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/contacto/editar/{id}")
    public ResponseEntity<Contacto> editarContacto (@RequestBody Contacto contact, @PathVariable int id){
        if(contactServ.buscarContacto(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          Contacto nuevoContacto = contactServ.editarContacto(id, contact);
        return new ResponseEntity<>(nuevoContacto, HttpStatus.OK);
        
    }
    
   
    
     @GetMapping ("/contacto/traer/lista")
       public ResponseEntity<List<Contacto>> list(){
           List<Contacto> list = contactServ.mostrarContacto();
           return new ResponseEntity(list, HttpStatus.OK);
    }
       
       @GetMapping("/contacto/traer/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id") int id){
        if(contactServ.buscarContacto(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Contacto contact = contactServ.buscarContacto(id);
        return new ResponseEntity(contact, HttpStatus.OK);
    }
    
}

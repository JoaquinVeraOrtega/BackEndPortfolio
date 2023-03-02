
package com.portfolio.BackEnd.controller;




import com.portfolio.BackEnd.IService.IPersonaService;
import com.portfolio.BackEnd.model.Persona;
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
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/persona/agregar")
    public void agregarPersona (@RequestBody Persona perso){
        persoServ.agregarPersona(perso);
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/persona/borrar/{id}")
    public void borrarPersona (@PathVariable int id) {
        persoServ.borrarPersona(id);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/persona/editar/{id}")
    public ResponseEntity<Persona> editarPersona (@RequestBody Persona perso, @PathVariable int id){
        if(persoServ.buscarPersona(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          Persona nuevaPersona = persoServ.editarPersona(id, perso);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.OK);
        
    }
    
   
    
     @GetMapping ("/persona/traer/lista")
       public ResponseEntity<List<Persona>> list(){
           List<Persona> list = persoServ.mostrarPersonas();
           return new ResponseEntity(list, HttpStatus.OK);
    }
       
       @GetMapping("/persona/traer/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(persoServ.buscarPersona(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = persoServ.buscarPersona(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
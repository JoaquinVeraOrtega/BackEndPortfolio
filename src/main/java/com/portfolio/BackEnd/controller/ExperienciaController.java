
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.IService.IExperienciaService;
import com.portfolio.BackEnd.model.Experiencia;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expeServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/experiencia/agregar")
    public void agregarExperiencia (@RequestBody Experiencia expe){
        expeServ.agregarExperiencia(expe);
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/experiencia/borrar/{id}")
    public void borrarExperiencia (@PathVariable int id) {
        expeServ.borrarExperiencia(id);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/experiencia/editar/{id}")
    public ResponseEntity<Experiencia> editarExperiencia (@RequestBody Experiencia expe, @PathVariable int id){
        if(expeServ.buscarExperiencia(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          Experiencia nuevaExperiencia = expeServ.editarExperiencia(id, expe);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.OK);
        
    }
    
   
    
     @GetMapping ("/experiencia/traer/lista")
       public ResponseEntity<List<Experiencia>> list(){
           List<Experiencia> list = expeServ.mostrarExperiencias();
           return new ResponseEntity(list, HttpStatus.OK);
    }
       
       @GetMapping("/experiencia/traer/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(expeServ.buscarExperiencia(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia expe = expeServ.buscarExperiencia(id);
        return new ResponseEntity(expe, HttpStatus.OK);
    }
    
}

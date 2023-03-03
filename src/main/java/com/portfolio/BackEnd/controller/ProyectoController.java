
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Proyecto;
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
import com.portfolio.BackEnd.IService.IProyectoService;

@RestController
@CrossOrigin (origins = "https://miportfolio-5dafe.web.app")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/proyecto/agregar")
    public void agregarProyecto (@RequestBody Proyecto proyect){
        proyectServ.agregarProyecto(proyect);
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/proyecto/borrar/{id}")
    public void borrarProyecto (@PathVariable int id) {
        proyectServ.borrarProyecto(id);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/proyecto/editar/{id}")
    public ResponseEntity<Proyecto> editarProyecto (@RequestBody Proyecto proyect, @PathVariable int id){
        if(proyectServ.buscarProyecto(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          Proyecto nuevoProyecto = proyectServ.editarProyecto(id, proyect);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.OK);
        
    }
    
   
    
     @GetMapping ("/proyecto/traer/lista")
       public ResponseEntity<List<Proyecto>> list(){
           List<Proyecto> list = proyectServ.mostrarProyectos();
           return new ResponseEntity(list, HttpStatus.OK);
    }
       
       @GetMapping("/proyecto/traer/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(proyectServ.buscarProyecto(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyect = proyectServ.buscarProyecto(id);
        return new ResponseEntity(proyect, HttpStatus.OK);
    }
    
}

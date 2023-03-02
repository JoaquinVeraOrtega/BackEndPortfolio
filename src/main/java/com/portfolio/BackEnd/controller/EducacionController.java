
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.IService.IEducacionService;
import com.portfolio.BackEnd.model.Educacion;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService educServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/educacion/agregar")
    public void agregarEducacion (@RequestBody Educacion educ){
        educServ.agregarEducacion(educ);
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/educacion/borrar/{id}")
    public void borrarEducacion (@PathVariable int id) {
        educServ.borrarEducacion(id);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/educacion/editar/{id}")
    public ResponseEntity<Educacion> editarEducacion (@RequestBody Educacion educ, @PathVariable int id){
        if(educServ.buscarEducacion(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          Educacion nuevaEducacion = educServ.editarEducacion(id, educ);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.OK);
        
    }
    
   
    
     @GetMapping ("/educacion/traer/lista")
       public ResponseEntity<List<Educacion>> list(){
           List<Educacion> list = educServ.mostrarEducacion();
           return new ResponseEntity(list, HttpStatus.OK);
    }
       
       @GetMapping("/educacion/traer/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(educServ.buscarEducacion(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educ = educServ.buscarEducacion(id);
        return new ResponseEntity(educ, HttpStatus.OK);
    }
    
}

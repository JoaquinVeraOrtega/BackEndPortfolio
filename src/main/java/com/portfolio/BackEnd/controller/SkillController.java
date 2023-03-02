
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Skill;
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
import com.portfolio.BackEnd.IService.ISkillService;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class SkillController {
    
    @Autowired
    private ISkillService skillServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/skill/agregar")
    public void agregarSkill (@RequestBody Skill skill){
        skillServ.agregarSkill(skill);
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/skill/borrar/{id}")
    public void borrarSkill (@PathVariable int id) {
        skillServ.borrarSkill(id);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/skill/editar/{id}")
    public ResponseEntity<Skill> editarSkill (@RequestBody Skill skill, @PathVariable int id){
        if(skillServ.buscarSkill(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
          Skill nuevaSkill = skillServ.editarSkill(id, skill);
        return new ResponseEntity<>(nuevaSkill, HttpStatus.OK);
        
    }
    
   
    
     @GetMapping ("/skill/traer/lista")
       public ResponseEntity<List<Skill>> list(){
           List<Skill> list = skillServ.mostrarSkills();
           return new ResponseEntity(list, HttpStatus.OK);
    }
       
       @GetMapping("/skill/traer/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(skillServ.buscarSkill(id) == null)
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillServ.buscarSkill(id);
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
}

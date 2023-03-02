
package com.portfolio.BackEnd.IService;

import com.portfolio.BackEnd.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
     public void agregarEducacion (Educacion educ);
    
    public void borrarEducacion (int id);
    
    public Educacion editarEducacion (int id, Educacion nuevaEducacion);
    
    public Educacion buscarEducacion (int id);
    
    public List <Educacion> mostrarEducacion ();
    
}

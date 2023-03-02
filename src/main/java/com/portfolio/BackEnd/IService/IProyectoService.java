
package com.portfolio.BackEnd.IService;

import com.portfolio.BackEnd.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
     public void agregarProyecto (Proyecto proyect);
    
    public void borrarProyecto (int id);
    
    public Proyecto editarProyecto (int id, Proyecto nuevoProyecto);
    
    public Proyecto buscarProyecto (int id);
    
    public List <Proyecto> mostrarProyectos ();
    
}

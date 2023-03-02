
package com.portfolio.BackEnd.IService;


import com.portfolio.BackEnd.model.Persona;
import java.util.List;




public interface IPersonaService {
    
    public void agregarPersona (Persona perso);
    
    public void borrarPersona (int id);
    
    public Persona editarPersona (int id, Persona nuevaPersona);
    
    public Persona buscarPersona (int id);
    
    public List <Persona> mostrarPersonas ();
    
    
    
}

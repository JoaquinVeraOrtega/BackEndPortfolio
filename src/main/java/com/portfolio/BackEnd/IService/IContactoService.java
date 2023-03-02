
package com.portfolio.BackEnd.IService;


import com.portfolio.BackEnd.model.Contacto;
import java.util.List;


public interface IContactoService {
    
     public void agregarContacto (Contacto contact);
    
    public void borrarContacto (int id);
    
    public Contacto editarContacto (int id, Contacto nuevoContacto);
    
    public Contacto buscarContacto (int id);
    
    public List <Contacto> mostrarContacto ();
    
}

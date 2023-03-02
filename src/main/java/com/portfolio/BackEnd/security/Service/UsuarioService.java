
package com.portfolio.BackEnd.security.Service;



import com.portfolio.BackEnd.security.Entity.Usuario;
import com.portfolio.BackEnd.security.Repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    IUsuarioRepository IusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return IusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return IusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return IusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        IusuarioRepository.save(usuario);
    }
    
}

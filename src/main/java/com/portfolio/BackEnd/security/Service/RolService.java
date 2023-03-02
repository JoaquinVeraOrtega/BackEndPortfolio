
package com.portfolio.BackEnd.security.Service;





import com.portfolio.BackEnd.security.Entity.Rol;
import com.portfolio.BackEnd.security.Enums.RolNombre;
import com.portfolio.BackEnd.security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository IrolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return IrolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        IrolRepository.save(rol);
    }
    
}
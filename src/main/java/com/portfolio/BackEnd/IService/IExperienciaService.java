package com.portfolio.BackEnd.IService;

import com.portfolio.BackEnd.model.Experiencia;
import java.util.List;

public interface IExperienciaService {

    public void agregarExperiencia (Experiencia expe);

    public void borrarExperiencia (int id);

    public Experiencia editarExperiencia (int id, Experiencia nuevaExpe);

    public Experiencia buscarExperiencia (int id);

    public List <Experiencia> mostrarExperiencias();
}

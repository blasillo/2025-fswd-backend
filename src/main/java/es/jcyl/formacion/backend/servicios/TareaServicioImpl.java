package es.jcyl.formacion.backend.servicios;

import es.jcyl.formacion.backend.modelos.TareaModelo;
import es.jcyl.formacion.backend.persistencia.entidades.Tarea;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import es.jcyl.formacion.backend.persistencia.repositorios.TareasRepositorio;
import es.jcyl.formacion.backend.persistencia.repositorios.UsuariosRepositorio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO : anotación requerida

// TODO : anotaciones necesarios

public class TareaServicioImpl implements TareaServicio {

    // TODO : inyectar dependecias
    // TareasRepositorio tareasRepo;
    // UsuariosRepositorio usuariosRepo;


    // TODO: inyectar dependencia
    // TareaMapeo mapeo;


    @Override
    public TareaModelo crearTarea(TareaModelo tarea) {
        Usuario usuario = usuariosRepo.findByCorreo( tarea.getUsuarioCorreo() )
                .orElseThrow( () ->  new EntityNotFoundException("El usuario no existe"));

        Tarea nueva =  tareasRepo.save (  mapeo.deModeloAEntidad( tarea , usuario )  );
        return mapeo.deEntidadAModelo( nueva ) ;
    }

    @Override
    public List<TareaModelo> obtenerTareas(String correo) {
        // TODO: recuperar usuario a partir del correo
        Optional<Usuario> usuario //TODO
        if(usuario.isEmpty()) {
            throw new EntityNotFoundException("El usuario no existe");
        }

        List<Tarea> tareas  //TODO
        List<TareaModelo> respuesta //TODO

        return respuesta;
    }

    @Override
    public TareaModelo modificarTarea(TareaModelo modelo) {
        Optional<Tarea> tarea = tareasRepo.findById(modelo.getId());
        if(tarea.isEmpty()) {
            throw new EntityNotFoundException("La tarea no existe");
        }
        Optional<Usuario> usuario = usuariosRepo.findByCorreo(modelo.getUsuarioCorreo());
        if(usuario.isEmpty()) {
            throw new EntityNotFoundException("El usuario no existe");
        }
        return mapeo.deEntidadAModelo( tareasRepo.save( mapeo.deModeloAEntidad (modelo,usuario.get()) ) );
    }

    @Override
    public Integer borrarTarea(Integer tareaId) {
        Optional<Tarea> tarea //TODO
        if(tarea.isEmpty()) {
            throw new EntityNotFoundException("La tarea no existe");
        }
        //TODO: si existe, borrar tarea

        return tareaId;
    }
}

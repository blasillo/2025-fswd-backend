package es.jcyl.formacion.backend.servicios;

import es.jcyl.formacion.backend.modelos.TareaModelo;
import es.jcyl.formacion.backend.persistencia.entidades.Tarea;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import org.springframework.stereotype.Service;

@Service
public class TareaMapeo {

    public Tarea deModeloAEntidad (TareaModelo modelo, Usuario usuario) {

        return Tarea.builder()
                .id ( modelo.getId())
                .nombre( modelo.getNombre())
                .estado( modelo.getEstado())
                .color(modelo.getColor())
                .usuario( usuario )
                .build();
    }

    public TareaModelo deEntidadAModelo (Tarea tarea) {

        return TareaModelo.builder()
                //TODO: convertir de entidad a modelo
                .build();
    }
}

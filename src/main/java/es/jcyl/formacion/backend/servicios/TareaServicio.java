package es.jcyl.formacion.backend.servicios;

import es.jcyl.formacion.backend.modelos.TareaModelo;

import java.util.List;

public interface TareaServicio {

    // definir CRUD
    TareaModelo crearTarea (TareaModelo tarea );
    List<TareaModelo> obtenerTareas (String email );

    TareaModelo modificarTarea (TareaModelo tarea);
    Integer borrarTarea (Integer tareaId);
}

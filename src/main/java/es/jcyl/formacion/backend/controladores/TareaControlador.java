package es.jcyl.formacion.backend.controladores;


import es.jcyl.formacion.backend.modelos.TareaModelo;
import es.jcyl.formacion.backend.servicios.TareaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tareas")
@RequiredArgsConstructor
//TODO
@CrossOrigin(origins = "*", allowCredentials = "true")
public class TareaControlador {

    private final TareaServicio servicio;


    @PostMapping
    public ResponseEntity<TareaModelo>  nuevaTarea (
            @Valid @RequestBody TareaModelo modelo) {
        return ResponseEntity.ok(  servicio.crearTarea ( modelo) );
    }

    @GetMapping
    public ResponseEntity<List<TareaModelo>> listadoTareas (
            @RequestParam("correo") String correo) {
        return ResponseEntity.ok ( servicio.obtenerTareas(correo));
    }

    @PutMapping()
    public ResponseEntity<TareaModelo> editarTarea (
            @Valid @RequestBody TareaModelo modelo) {
        return ResponseEntity.ok( servicio.modificarTarea( modelo ));
    }

    @DeleteMapping()
    public Integer deleteTodo(@RequestParam("tareaId") Integer id) {
        return servicio.borrarTarea( id );
    }
}

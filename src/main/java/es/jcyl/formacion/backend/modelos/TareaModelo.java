package es.jcyl.formacion.backend.modelos;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TareaModelo {

    private Integer id;

    //TODO
    private String  nombre;

    //TODO
    private Integer estado;

    //TODO
    private String  color;

    //TODO
    private String  usuarioCorreo;
}

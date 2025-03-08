package es.jcyl.formacion.backend.persistencia.entidades;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//TODO
//TODO
@EntityListeners(AuditingEntityListener.class)
public class Tarea {

    //TODO
    //TODO
    //TODO
    private Integer id;

    //TODO
    private String nombre;

    //TODO
    private Integer estado;

    //TODO
    private String color;

    //TODO
    //TODO
    private Usuario usuario;


    @CreatedDate
    @Column(name="F_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name="F_MODIFICACION",insertable = false)
    private LocalDateTime fechaModificacion;

}
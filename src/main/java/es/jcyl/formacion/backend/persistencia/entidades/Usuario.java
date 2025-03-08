package es.jcyl.formacion.backend.persistencia.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//TODO
//TODO
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    //TODO
    //TODO
    //TODO
    private Integer id;

    //TODO
    private String nombreCompleto;

    //TODO
    private String iniciales;

    //TODO
    private String correo;

    //TODO
    private String clave;

    //TODO
    private List<Rol> roles;

    @CreatedDate
    @Column(name="F_CREACION", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name="F_MODIFICACION",insertable = false)
    private LocalDateTime fechaModificacion;
}
package es.jcyl.formacion.backend.persistencia.repositorios;

import es.jcyl.formacion.backend.persistencia.entidades.Rol;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepositorio extends JpaRepository<Usuario,Integer> {

    //TODO: buscar un usuario por el correo
    Optional<Usuario> xxxxxxx (String correo);

    //TODO: Buscar usuario por correo y clave
    Optional<Usuario> yyyyyy (String correo, String clave);

    //TODO: ver si un usuario con un correo existe
    Boolean zzzzzzzzzzzz (String correo);

    // TODO: listado de los usuarios que tienen el rol de administrador

    List<Usuario> listadoAdministradores ();
}
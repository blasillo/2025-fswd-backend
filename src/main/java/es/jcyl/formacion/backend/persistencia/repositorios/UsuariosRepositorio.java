package es.jcyl.formacion.backend.persistencia.repositorios;

import es.jcyl.formacion.backend.persistencia.entidades.Rol;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepositorio extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByCorreo (String correo);

    Optional<Usuario> findByCorreoAndClave(String correo, String clave);

    Boolean  existsByCorreo (String correo);


    @Query ("""
       select u
        from Usuario u JOIN u.roles r 
       WHERE r.nombre = 'ADMINISTRADOR'       
    """)
    List<Usuario> listadoAdministradores ();
}
package es.jcyl.formacion.backend.persistencia.repositorios;

import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.querydsl.jpa.impl.JPAQuery;
import es.jcyl.formacion.backend.persistencia.entidades.Rol;

import es.jcyl.formacion.backend.persistencia.entidades.QUsuario; // Importa desde el paquete de las entidades
import es.jcyl.formacion.backend.persistencia.entidades.QRol;   // Importa desde el paquete de las entidades

import java.util.List;

public class UsuariosRepositorioImpl implements UsuariosRepositorioCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> listadoUsuariosBase() {

        QUsuario usuario = QUsuario.usuario;
        QRol rol = QRol.rol;
        return new JPAQuery<Usuario>(entityManager)
                .from(usuario)
                .join(usuario.roles, rol)
                .where(rol.nombre.eq("BASE"))
                .fetch();

    }
}

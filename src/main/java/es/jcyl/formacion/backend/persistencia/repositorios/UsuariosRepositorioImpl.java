package es.jcyl.formacion.backend.persistencia.repositorios;

import es.jcyl.formacion.backend.persistencia.entidades.Rol;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuariosRepositorioImpl implements UsuariosRepositorioCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> listadoUsuarios() {
        // Crear el CriteriaBuilder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Crear el CriteriaQuery para la entidad Usuario
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);

        // Definir la raíz de la consulta (Usuario)
        Root<Usuario> usuarioRoot = cq.from(Usuario.class);

        // Hacer un JOIN con la colección de roles
        Join<Usuario, Rol> rolJoin = usuarioRoot.join("roles");

        // Definir el Predicate para filtrar por el nombre del rol
        Predicate condicion = cb.equal(rolJoin.get("nombre"), "BASE");

        // Aplicar el WHERE con la condición
        cq.where(condicion);

        // Seleccionar los resultados
        cq.select(usuarioRoot);

        // Ejecutar la consulta y devolver la lista
        return entityManager.createQuery(cq).getResultList();

    }
}

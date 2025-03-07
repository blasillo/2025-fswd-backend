package es.jcyl.formacion.backend.persistencia.repositorios;

import es.jcyl.formacion.backend.persistencia.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepositorio extends JpaRepository<Rol,Integer> {
}
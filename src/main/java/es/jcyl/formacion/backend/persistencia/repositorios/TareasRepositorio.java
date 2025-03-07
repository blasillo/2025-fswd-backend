package es.jcyl.formacion.backend.persistencia.repositorios;

import es.jcyl.formacion.backend.persistencia.entidades.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasRepositorio extends JpaRepository<Tarea,Integer> {
}
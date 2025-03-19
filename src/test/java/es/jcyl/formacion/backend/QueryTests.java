package es.jcyl.formacion.backend;


import es.jcyl.formacion.backend.persistencia.entidades.Tarea;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import es.jcyl.formacion.backend.persistencia.repositorios.RolesRepositorio;
import es.jcyl.formacion.backend.persistencia.repositorios.TareasRepositorio;
import es.jcyl.formacion.backend.persistencia.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Usa Oracle configurado
public class QueryTests {

    @Autowired
    private RolesRepositorio rolRepo;

    @Autowired
    private UsuariosRepositorio usuarioRepo;

    @Autowired
    private TareasRepositorio tareaRepo;
    @Autowired
    private RolesRepositorio rolesRepositorio;


    @Test
    public void testExistsByCorreo() {
        // Preparar datos
        Usuario usuario = Usuario.builder()
                .correo("exists@eclap.jcyl.es")
                .clave ("pass123")
                .nombreCompleto("Exists User")
                .build();
        usuarioRepo.save(usuario);

        // Ejecutar consulta
        boolean exists = usuarioRepo.existsByCorreo("exists@eclap.jcyl.es");
        boolean notExists = usuarioRepo.existsByCorreo("noexists@eclap.jcyl.es");

        // Verificar
        assertTrue(exists);
        assertFalse(notExists);
    }

    @Test
    public void testListadoAdministradores() {

        List<Usuario> admins = usuarioRepo.listadoAdministradores();

        assertFalse(admins.isEmpty());
        assertEquals("formacion@eclap.jcyl.es", admins.get(0).getCorreo());
    }


    @Test
    public void testTareasPorUsuario() {
        // Insertar un usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo("user@eclap.jcyl.es");
        usuario.setClave("pass123");
        usuario = usuarioRepo.save(usuario);

        // Insertar tareas para el usuario
        Tarea tarea1 = new Tarea();
        tarea1.setNombre("Tarea 1");
        tarea1.setEstado(10);
        tarea1.setUsuario(usuario);
        tareaRepo.save(tarea1);

        Tarea tarea2 = new Tarea();
        tarea2.setNombre("Tarea 2");
        tarea2.setEstado(90);
        tarea2.setUsuario(usuario);
        tareaRepo.save(tarea2);

        // Ejecutar consulta
        List<Tarea> tareas = tareaRepo.findByUsuario(usuario);

        // Verificar
        assertEquals(2, tareas.size());
        assertTrue(tareas.stream().anyMatch(t -> "Tarea 1".equals(t.getNombre())));
        assertTrue(tareas.stream().anyMatch(t -> "Tarea 2".equals(t.getNombre())));
    }

}

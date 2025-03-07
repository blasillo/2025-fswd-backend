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

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Usa Oracle configurado
public class EntityMappingTests {

    @Autowired
    private RolesRepositorio rolRepo;

    @Autowired
    private UsuariosRepositorio usuarioRepo;

    @Autowired
    private TareasRepositorio tareaRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsertTarea() {

        Optional<Usuario> usuario =  usuarioRepo.findById(1);

        Tarea tarea = Tarea.builder()
                .estado(50)
                .usuario(usuario.get())
                .color("Azul")
                .nombre("Tarea de prueba")
                .build();
        tarea = tareaRepo.save(tarea);

        Tarea savedTarea = tareaRepo.findById(tarea.getId()).orElse(null);

        assertNotNull(savedTarea);
        assertEquals("Tarea de prueba", savedTarea.getNombre());
    }

    @Test
    public void testReadUsuarios() {
        Optional<Usuario> usuario =  usuarioRepo.findById(1);

        assertNotNull( usuario.get() );
        assertEquals(2 , usuario.get().getRoles().size());
    }
}
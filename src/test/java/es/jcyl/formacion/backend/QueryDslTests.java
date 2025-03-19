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
public class QueryDslTests {
    @Autowired
    private RolesRepositorio rolRepo;

    @Autowired
    private UsuariosRepositorio usuariosRepo;

    @Autowired
    private TareasRepositorio tareaRepo;


    @Test
    public void testListadoUsuariosBase() {
        // Insertar un usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo("user@eclap.jcyl.es");
        usuario.setClave("pass123");
        usuario.setRoles( rolRepo.findAll().stream()
                .filter(rol -> rol.getNombre().equals("BASE")).toList() );
        usuario = usuariosRepo.save(usuario);


        List<Usuario> base = usuariosRepo.listadoUsuariosBase();


        assertTrue(base.stream().allMatch(u -> u.getRoles().stream().anyMatch(r -> r.getNombre().equals("BASE"))),
                "Todos los usuarios deben tener el rol BASE");
    }
}

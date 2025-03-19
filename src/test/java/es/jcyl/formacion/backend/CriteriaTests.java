package es.jcyl.formacion.backend;


import es.jcyl.formacion.backend.persistencia.entidades.Rol;
import es.jcyl.formacion.backend.persistencia.entidades.Usuario;
import es.jcyl.formacion.backend.persistencia.repositorios.RolesRepositorio;
import es.jcyl.formacion.backend.persistencia.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Usa Oracle configurado
public class CriteriaTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuariosRepositorio usuarioRepo;

    @Autowired
    private RolesRepositorio rolesRepo;

    @Test
    public void testListadoUsuarios() {

        List<Rol> roles = rolesRepo.findAll();

        Usuario usuario = new Usuario();
        usuario.setCorreo("user@eclap.jcyl.es");
        usuario.setClave("pass123");
        usuario.setRoles( roles );
        usuario = usuarioRepo.save(usuario);


        List<Usuario> base = usuarioRepo.listadoUsuarios();

        System.out.println( base.toString());

        assertEquals("BASE", base.get(0).getRoles().get(0).getNombre());

    }



}

package es.jcyl.formacion.backend;

import es.jcyl.formacion.backend.modelos.TareaModelo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidationTareaTests {

    @Autowired
    private Validator validator;

    @Test
    public void testTareaValida() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(0)
                .color("ROJO")
                .usuarioCorreo("formacion@eclap.jcyl.es").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertTrue(violations.isEmpty());

    }


    @Test
    public void testNombreSizeMax() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("a".repeat(201))
                .estado(0)
                .color("ROJO")
                .usuarioCorreo("formacion@eclap.jcyl.es").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "nombre".equals(v.getPropertyPath().toString())));
    }

    @Test
    public void testEstadoMin() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(-1)
                .color("ROJO")
                .usuarioCorreo("formacion@eclap.jcyl.es").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "estado".equals(v.getPropertyPath().toString())));
    }

    @Test
    public void testEstadoMax() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(101)
                .color("ROJO")
                .usuarioCorreo("formacion@eclap.jcyl.es").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "estado".equals(v.getPropertyPath().toString())));
    }

    @Test
    public void testColorSizeMax() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(0)
                .color("a".repeat(51))
                .usuarioCorreo("formacion@eclap.jcyl.es").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "color".equals(v.getPropertyPath().toString())));
    }

    @Test
    public void testUsuarioCorreoNotNull() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(0)
                .color("ROJO")
                .build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "usuarioCorreo".equals(v.getPropertyPath().toString())));
    }

    @Test
    public void testUsuarioCorreoNotEmpty() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(0)
                .color("ROJO")
                .usuarioCorreo("").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "usuarioCorreo".equals(v.getPropertyPath().toString())));
    }

    @Test
    public void testUsuarioCorreoEmail() {
        TareaModelo tarea = TareaModelo.builder()
                .nombre("Demo")
                .estado(0)
                .color("ROJO")
                .usuarioCorreo("formacion@").build();

        Set<jakarta.validation.ConstraintViolation<TareaModelo>> violations = validator.validate(tarea);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream()
                .anyMatch(v -> "usuarioCorreo".equals(v.getPropertyPath().toString())));
    }


}
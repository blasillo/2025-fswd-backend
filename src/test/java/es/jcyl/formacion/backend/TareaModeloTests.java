package es.jcyl.formacion.backend;

import es.jcyl.formacion.backend.modelos.TareaModelo;
import es.jcyl.formacion.backend.servicios.TareaServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TareaModeloTests {

    @Autowired
    TareaServicio tareaSrv;


    @Test
    void contextLoads() {
    }

    @Test
    public void testCrudTarea() {
        TareaModelo modelo = TareaModelo.builder()
                .nombre("Demo")
                .estado(0)
                .color("ROJO")
                .usuarioCorreo("formacion@eclap.jcyl.es").build();

        TareaModelo resultado = tareaSrv.crearTarea( modelo );

        System.out.println( "Tarea creada : " + resultado.getNombre() + " por " + resultado.getUsuarioCorreo() );

        assertNotNull(resultado);

        List<TareaModelo> misTareas = tareaSrv.obtenerTareas( "formacion@eclap.jcyl.es" );
        misTareas.forEach( t -> { System.out.println ("Mi Tarea : " + t.getNombre() + " por " + t.getUsuarioCorreo()  ); } );

        assertNotNull(misTareas);
        assertTrue (!misTareas.isEmpty());

        resultado.setNombre ("Demo terminada");
        TareaModelo resultado2 = tareaSrv.modificarTarea( resultado );
        System.out.println( "Tarea modificada : " + resultado2.getNombre() + " por " + resultado2.getUsuarioCorreo() );

        assertEquals(  "Demo terminada" , resultado2.getNombre() );

        tareaSrv.borrarTarea(resultado2.getId());

        misTareas = tareaSrv.obtenerTareas( "formacion@eclap.jcyl.es" );
        System.out.println ("Contador Tareas: " + misTareas.size() );

        //assertEquals(0, misTareas.size());
    }


}

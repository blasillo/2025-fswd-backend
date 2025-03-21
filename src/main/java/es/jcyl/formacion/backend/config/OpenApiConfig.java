package es.jcyl.formacion.backend.config;


import es.jcyl.formacion.backend.controladores.GestorExcepcion;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.ControllerAdviceBean;

import java.util.Arrays;

@Configuration
@OpenAPIDefinition(
        info=@Info(
                description = "Aplicación del curso de FSWD",
                title = "OpenAPI Especificación",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Entorno local",
                        url = "http://localhost:8080/api/v1"
                )
        }
        // security
)

public class OpenApiConfig {

}


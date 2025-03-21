package es.jcyl.formacion.backend.controladores;

import es.jcyl.formacion.backend.excepciones.RespuestaExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


//@RestControllerAdvice
public class GestorExcepcion {

    private static final Logger logger = LoggerFactory.getLogger(GestorExcepcion.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> gestorNoValido(MethodArgumentNotValidException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> gestorExcepcion(Exception exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }
}

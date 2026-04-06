package arakamitech.com.msuruario.infrastructure.adapters.in.rest.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import arakamitech.com.msuruario.application.dto.response.Response;
import arakamitech.com.msuruario.shared.exception.DomainException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Response<Void>> handleDomainException(DomainException ex) {

        return ResponseEntity
                .status(ex.getError().getStatus())
                .body(Response.error(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleGeneralException(Exception ex) {

        log.error("Error inesperado", ex);

        return ResponseEntity
                .internalServerError()
                .body(Response.error("Error interno del servidor"));
    }
}
package arakamitech.com.msusuariowebflux.infrastructure.adapters.in.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import arakamitech.com.msusuariowebflux.application.dto.response.Response;
import arakamitech.com.msusuariowebflux.shared.exception.DomainException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public Mono<ResponseEntity<Response<Object>>> handleDomainException(DomainException ex) {
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(Response.error(ex.getMessage()))
        );
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Response<Object>>> handleGeneralException(Exception ex) {
        ex.printStackTrace();
        return Mono.just(
                ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Response.error(ex.getMessage()))
        );
    }
}
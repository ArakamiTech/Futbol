package arakamitech.com.msrol.shared.exception;

import org.springframework.http.HttpStatus;

public enum DomainError {

    ROL_NOMBRE_OBLIGATORIO(HttpStatus.BAD_REQUEST, "El nombre del rol es obligatorio"),
    ROL_NOMBRE_LONGITUD(HttpStatus.BAD_REQUEST, "El nombre no puede superar 50 caracteres"),
    ROL_NO_ENCONTRADO(HttpStatus.NOT_FOUND, "Rol no encontrado"), 
    ROL_DUPLICADO(HttpStatus.CONFLICT, "Rol duplicado");

    private final HttpStatus status;
    private final String message;

    DomainError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
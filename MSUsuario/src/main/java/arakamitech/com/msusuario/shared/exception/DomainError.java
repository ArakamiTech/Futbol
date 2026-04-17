package arakamitech.com.msusuario.shared.exception;

import org.springframework.http.HttpStatus;

public enum DomainError {

    ROL_NOMBRE_OBLIGATORIO(HttpStatus.BAD_REQUEST, "El nombre del rol es obligatorio"),
    ROL_NOMBRE_LONGITUD(HttpStatus.BAD_REQUEST, "El nombre no puede superar 50 caracteres"),
    ROL_NO_ENCONTRADO(HttpStatus.NOT_FOUND, "Rol no encontrado"), 
    ROL_DUPLICADO(HttpStatus.CONFLICT, "Rol duplicado"), 
    USUARIO_NUMERO_ID_OBLIGATORIO(HttpStatus.BAD_REQUEST, "El número de identificación es obligatorio"),
    USUARIO_NUMERO_ID_LONGITUD(HttpStatus.BAD_REQUEST, "El número de identificación no puede superar los 20 caracteres"),
    USUARIO_NOMBRE_OBLIGATORIO(HttpStatus.BAD_REQUEST, "El nombre es obligatorio"),
    USUARIO_NOMBRE_LONGITUD(HttpStatus.BAD_REQUEST, "El nombre no puede superar los 100 caracteres"),
    USUARIO_FECHA_OBLIGATORIA(HttpStatus.BAD_REQUEST, "La fecha de nacimiento es obligatoria"),
    USUARIO_FECHA_INVALIDA(HttpStatus.BAD_REQUEST, "La fecha de nacimiento no puede ser futura"),
    USUARIO_TIPO_ID_OBLIGATORIO(HttpStatus.BAD_REQUEST, "El tipo de identificación es obligatorio"),
    USUARIO_PAIS_OBLIGATORIO(HttpStatus.BAD_REQUEST, "El país es obligatorio"),
    USUARIO_DUPLICADO(HttpStatus.CONFLICT, "Ya existe un usuario con ese número de identificación"),
	USUARIO_NO_ENCONTRADO(HttpStatus.NOT_FOUND, "Usuario no encontrado"), 
	ERROR_CONSULTANDO_USUARIOS(HttpStatus.INTERNAL_SERVER_ERROR, "Error consultando Usuarios"), 
	ERROR_CONSULTANDO_ROLES(HttpStatus.INTERNAL_SERVER_ERROR, "Error consultando Roles"), 
	ERROR_GENERAL(HttpStatus.INTERNAL_SERVER_ERROR, "Error General de la aplicacion");

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
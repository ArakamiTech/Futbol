package arakamitech.com.msrol.domain.model;

import arakamitech.com.msrol.shared.exception.DomainError;
import arakamitech.com.msrol.shared.exception.DomainException;

public class Rol {

    private Long id;
    private String nombre;

    public Rol(Long id, String nombre) {
        validarNombre(nombre);
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public void actualizarNombre(String nuevoNombre) {
        validarNombre(nuevoNombre);
        this.nombre = nuevoNombre;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DomainException(DomainError.ROL_NOMBRE_OBLIGATORIO);
        }
        if (nombre.length() > 50) {
            throw new DomainException(DomainError.ROL_NOMBRE_LONGITUD);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

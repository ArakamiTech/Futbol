package arakamitech.com.msuruario.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import arakamitech.com.msuruario.shared.exception.DomainError;
import arakamitech.com.msuruario.shared.exception.DomainException;
import lombok.Getter;

@Getter
public class Usuario implements Serializable {

    private Long id;
    private String numeroIdentificacion;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Long tipoIdentificacionId;
    private Long paisId;
    
    public Usuario(Long id,
            String numeroIdentificacion,
            String nombre,
            LocalDate fechaNacimiento,
            Long tipoIdentificacionId,
            Long paisId) {

	 this(numeroIdentificacion, nombre, fechaNacimiento, tipoIdentificacionId, paisId);
	 this.id = id;
	}
    
    public Usuario(String numeroIdentificacion,
            	   String nombre,
		           LocalDate fechaNacimiento,
		           Long tipoIdentificacionId,
		           Long paisId) {

		validarNumeroIdentificacion(numeroIdentificacion);
		validarNombre(nombre);
		validarFechaNacimiento(fechaNacimiento);
		validarIds(tipoIdentificacionId, paisId);

		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoIdentificacionId = tipoIdentificacionId;
		this.paisId = paisId;
	}

    public void actualizar(String nombre,
                           LocalDate fechaNacimiento,
                           Long tipoIdentificacionId,
                           Long paisId) {

        validarNombre(nombre);
        validarFechaNacimiento(fechaNacimiento);
        validarIds(tipoIdentificacionId, paisId);

        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoIdentificacionId = tipoIdentificacionId;
        this.paisId = paisId;
    }

    private void validarNumeroIdentificacion(String numero) {
        if (numero == null || numero.isBlank()) {
            throw new DomainException(DomainError.USUARIO_NUMERO_ID_OBLIGATORIO);
        }
        if (numero.length() > 20) {
            throw new DomainException(DomainError.USUARIO_NUMERO_ID_LONGITUD);
        }
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DomainException(DomainError.USUARIO_NOMBRE_OBLIGATORIO);
        }
        if (nombre.length() > 100) {
            throw new DomainException(DomainError.USUARIO_NOMBRE_LONGITUD);
        }
    }

    private void validarFechaNacimiento(LocalDate fecha) {
        if (fecha == null) {
            throw new DomainException(DomainError.USUARIO_FECHA_OBLIGATORIA);
        }
        if (fecha.isAfter(LocalDate.now())) {
            throw new DomainException(DomainError.USUARIO_FECHA_INVALIDA);
        }
    }

    private void validarIds(Long tipoId, Long paisId) {
        if (tipoId == null) {
            throw new DomainException(DomainError.USUARIO_TIPO_ID_OBLIGATORIO);
        }
        if (paisId == null) {
            throw new DomainException(DomainError.USUARIO_PAIS_OBLIGATORIO);
        }
    }
}
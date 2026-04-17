package arakamitech.com.msusuario.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import arakamitech.com.msusuario.shared.exception.DomainError;
import arakamitech.com.msusuario.shared.exception.DomainException;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getTipoIdentificacionId() {
		return tipoIdentificacionId;
	}

	public void setTipoIdentificacionId(Long tipoIdentificacionId) {
		this.tipoIdentificacionId = tipoIdentificacionId;
	}

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}
    
}
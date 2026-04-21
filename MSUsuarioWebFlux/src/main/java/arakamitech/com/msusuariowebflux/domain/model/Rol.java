package arakamitech.com.msusuariowebflux.domain.model;

import java.io.Serializable;

public class Rol implements Serializable {

	private Long id;
	private String nombre;

	public Rol(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	protected Rol() {
	}

	public Rol(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}

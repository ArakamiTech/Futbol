package arakamitech.com.msnotificaciones.domain.model;

import java.io.Serializable;

public class Notificacion implements Serializable {

	private String email;
    private String message;
	
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

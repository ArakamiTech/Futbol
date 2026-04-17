package arakamitech.com.msnotificaciones.domain.port.out;

public interface EmailSenderPort {

	void sendEmail(String email, String subject, String html);
	
}

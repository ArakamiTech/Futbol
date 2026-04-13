package arakamitech.com.msnotificaciones.domain.port.out;

public interface EmailSender {

	void sendEmail(String email, String subject, String html);
	
}

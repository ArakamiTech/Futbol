package arakamitech.com.msnotificaciones.infrastructure.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import arakamitech.com.msnotificaciones.domain.port.out.EmailSenderPort;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSenderPort {

	private final JavaMailSender mailSender;

	@Override
	public void sendEmail(String email, String subject, String html) {
		log.info("Correo enviado a {}", email);
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(html, true);

			mailSender.send(message);
			log.info("Correo enviado a {}", email);
		} catch (Exception e) {
			log.error("Error enviando el correo a {}", email);
			throw new RuntimeException("Error enviando correo", e);
		}
	}
}

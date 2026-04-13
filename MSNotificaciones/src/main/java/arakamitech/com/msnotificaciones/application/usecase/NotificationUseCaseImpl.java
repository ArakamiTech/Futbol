package arakamitech.com.msnotificaciones.application.usecase;

import org.springframework.stereotype.Service;

import arakamitech.com.msnotificaciones.domain.port.in.NotificationUsecase;
import arakamitech.com.msnotificaciones.domain.port.out.EmailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationUseCaseImpl implements NotificationUsecase {

    private final EmailSender emailSender;

    @Override
    public void notificarEmail(String email, String message) {
        log.info("Enviando correo a {}", email);

        String html = buildHtml(message);
        emailSender.sendEmail(email, "Notificación", html);

        log.info("Correo enviado a {}", email);
    }
    
    public String buildHtml(String mensaje) {
        return """
            <html>
            <body style="font-family: Arial; background-color: #f4f4f4; padding: 20px;">
                <div style="max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 10px;">
                    
                    <h2 style="color: #2c3e50;">Notificación</h2>
                    
                    <p style="font-size: 16px; color: #555;">
                        %s
                    </p>
                    
                    <hr>
                    
                    <p style="font-size: 12px; color: #999;">
                        Este es un mensaje automático, por favor no responder.
                    </p>
                </div>
            </body>
            </html>
            """.formatted(mensaje);
    }

}

package arakamitech.com.msnotificaciones.infrastructure.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import arakamitech.com.msnotificaciones.domain.model.Notificacion;
import arakamitech.com.msnotificaciones.domain.port.in.NotificationUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificacionConsumer {

    private final NotificationUsecase notificationUseCase;

    @KafkaListener(topics = "notificaciones", groupId = "ms-notificaciones")
    public void consumir(Notificacion evento) {
        try {
            log.info("Procesando notificación para {}", evento.getEmail());

            notificationUseCase.notificarEmail(
                evento.getEmail(),
                evento.getMessage()
            );

        } catch (Exception e) {
            log.error("Error procesando notificación", e);
        }
    }

}

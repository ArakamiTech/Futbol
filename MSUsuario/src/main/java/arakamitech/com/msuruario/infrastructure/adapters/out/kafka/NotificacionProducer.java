package arakamitech.com.msuruario.infrastructure.adapters.out.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import arakamitech.com.msuruario.infrastructure.adapters.out.kafka.event.NotificacionEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificacionProducer {

    private final KafkaTemplate<String, NotificacionEvent> kafkaTemplate;

    private static final String TOPIC = "notificaciones";

    public void enviar(NotificacionEvent evento) {
        kafkaTemplate.send(TOPIC, evento);
    }
}
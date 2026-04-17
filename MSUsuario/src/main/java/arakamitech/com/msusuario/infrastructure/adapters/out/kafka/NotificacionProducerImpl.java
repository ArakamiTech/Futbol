package arakamitech.com.msusuario.infrastructure.adapters.out.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import arakamitech.com.msusuario.domain.port.out.NotificacionProducerPort;
import arakamitech.com.msusuario.infrastructure.adapters.out.kafka.event.NotificacionEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificacionProducerImpl implements NotificacionProducerPort {

	private final KafkaTemplate<String, NotificacionEvent> kafkaTemplate;

	private static final String TOPIC = "notificaciones";

	@Override
	public void enviar(NotificacionEvent evento) {
		kafkaTemplate.send(TOPIC, evento);
	}
}
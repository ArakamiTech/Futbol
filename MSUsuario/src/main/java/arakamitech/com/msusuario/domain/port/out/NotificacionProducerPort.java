package arakamitech.com.msusuario.domain.port.out;

import arakamitech.com.msusuario.infrastructure.adapters.out.kafka.event.NotificacionEvent;

public interface NotificacionProducerPort {
	
	public void enviar(NotificacionEvent evento);

}

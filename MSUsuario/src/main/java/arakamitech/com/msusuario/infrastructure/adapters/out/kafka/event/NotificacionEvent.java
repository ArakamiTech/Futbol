package arakamitech.com.msusuario.infrastructure.adapters.out.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacionEvent {
	
	private String email;
    private String mensaje;

}

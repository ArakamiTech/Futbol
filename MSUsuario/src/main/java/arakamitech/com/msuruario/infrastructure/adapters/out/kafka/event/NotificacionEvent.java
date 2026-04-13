package arakamitech.com.msuruario.infrastructure.adapters.out.kafka.event;

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

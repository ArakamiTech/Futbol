package arakamitech.com.msuruario.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app.notificaciones")
@Data
public class NotificacionProperties {

    private String email;

}

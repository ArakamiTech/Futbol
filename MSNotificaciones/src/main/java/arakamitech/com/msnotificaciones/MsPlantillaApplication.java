package arakamitech.com.msnotificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MsPlantillaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPlantillaApplication.class, args);
	}

}

package arakamitech.com.msrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MsRolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRolApplication.class, args);
	}

}

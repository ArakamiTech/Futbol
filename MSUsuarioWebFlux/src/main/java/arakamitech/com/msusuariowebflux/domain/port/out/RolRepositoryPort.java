package arakamitech.com.msusuariowebflux.domain.port.out;

import java.util.List;

import arakamitech.com.msusuariowebflux.domain.model.Rol;
import reactor.core.publisher.Mono;

public interface RolRepositoryPort {

	Mono<List<Rol>> findAll();

}

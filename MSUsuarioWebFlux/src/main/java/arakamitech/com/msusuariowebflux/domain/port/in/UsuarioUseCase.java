package arakamitech.com.msusuariowebflux.domain.port.in;

import arakamitech.com.msusuariowebflux.domain.model.AllTables;
import reactor.core.publisher.Mono;

public interface UsuarioUseCase {

	Mono<AllTables> findAllTables();

}

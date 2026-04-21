package arakamitech.com.msusuariowebflux.domain.port.out;

import java.util.List;

import arakamitech.com.msusuariowebflux.domain.model.Usuario;
import reactor.core.publisher.Mono;

public interface UsuarioRepositoryPort {

	Mono<List<Usuario>> findAll();

}

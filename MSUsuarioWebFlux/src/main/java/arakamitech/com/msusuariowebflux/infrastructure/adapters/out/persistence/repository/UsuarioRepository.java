package arakamitech.com.msusuariowebflux.infrastructure.adapters.out.persistence.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.persistence.entity.UsuarioEntity;

public interface UsuarioRepository extends ReactiveCrudRepository<UsuarioEntity, Long> {
}

package arakamitech.com.msusuariowebflux.infrastructure.adapters.out.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import arakamitech.com.msusuariowebflux.domain.model.Usuario;
import arakamitech.com.msusuariowebflux.domain.port.out.UsuarioRepositoryPort;
import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.persistence.mapper.UsuarioPersistenceMapper;
import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository repository;
    private final UsuarioPersistenceMapper mapper;

    @Override
    public Mono<List<Usuario>> findAll() {
        return repository.findAll()
                .map(mapper::toDomain)
                .collectList();
    }
}
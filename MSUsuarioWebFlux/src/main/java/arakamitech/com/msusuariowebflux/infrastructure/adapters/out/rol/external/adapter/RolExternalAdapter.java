package arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Component;

import arakamitech.com.msusuariowebflux.domain.model.Rol;
import arakamitech.com.msusuariowebflux.domain.port.out.RolRepositoryPort;
import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter.client.RolClient;
import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter.response.Response;
import arakamitech.com.msusuariowebflux.shared.exception.DomainError;
import arakamitech.com.msusuariowebflux.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@Component
@RequiredArgsConstructor
public class RolExternalAdapter implements RolRepositoryPort {
	
	private final RolClient rolClient;

    @Override
    public Mono<List<Rol>> findAll() {
        return rolClient.findAll()
                .map(Response::getData)
                .map(list -> list.stream()
                        .map(r -> new Rol(r.getId(), r.getNombre()))
                        .toList()
                )
                .timeout(Duration.ofSeconds(3))
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1))
                        .filter(this::isRetryable))
                .onErrorMap(ex -> new DomainException(DomainError.ERROR_CONSULTANDO_ROLES));
    }
    
    private boolean isRetryable(Throwable ex) {
        return !(ex instanceof DomainException);
    }
}
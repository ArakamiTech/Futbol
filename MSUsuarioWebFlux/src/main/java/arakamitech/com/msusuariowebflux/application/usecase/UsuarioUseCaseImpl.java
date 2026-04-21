package arakamitech.com.msusuariowebflux.application.usecase;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import arakamitech.com.msusuariowebflux.domain.model.AllTables;
import arakamitech.com.msusuariowebflux.domain.port.in.UsuarioUseCase;
import arakamitech.com.msusuariowebflux.domain.service.FindAllTables;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final FindAllTables findAllTables;
    private final ReactiveRedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "alltables";

    @Override
    public Mono<AllTables> findAllTables() {
        return redisTemplate.opsForValue().get(KEY)
                .cast(AllTables.class)
                .switchIfEmpty(
                        findAllTables.findAllTables()
                                .flatMap(data ->
                                        redisTemplate.opsForValue()
                                                .set(KEY, data)
                                                .thenReturn(data)
                                )
                );
    }
}
package arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter.response.Response;
import arakamitech.com.msusuariowebflux.infrastructure.adapters.out.rol.external.adapter.response.RolResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RolClient {

    private final WebClient webClient;

    public Mono<Response<List<RolResponse>>> findAll() {
        return webClient.get()
                .uri("/api/msrol")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Response<List<RolResponse>>>() {});
    }
}

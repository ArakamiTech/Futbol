package arakamitech.com.msusuariowebflux.infrastructure.adapters.in.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arakamitech.com.msusuariowebflux.application.dto.response.AllTablesResponse;
import arakamitech.com.msusuariowebflux.application.dto.response.Response;
import arakamitech.com.msusuariowebflux.application.mapper.AllTablesMapper;
import arakamitech.com.msusuariowebflux.domain.port.in.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${request.mapping.controller.usuariocontroller}")
@RequiredArgsConstructor
public class Controller {

    private final UsuarioUseCase usuarioUseCase;
    private final AllTablesMapper allTableMapper;

    @GetMapping("/allTables")
    public Mono<ResponseEntity<Response<AllTablesResponse>>> findAllTables() {
        return usuarioUseCase.findAllTables()
                .map(allTableMapper::toResponse)
                .map(Response::ok)
                .map(ResponseEntity::ok);
    }
}



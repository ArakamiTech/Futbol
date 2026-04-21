package arakamitech.com.msusuariowebflux.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import arakamitech.com.msusuariowebflux.domain.model.AllTables;
import arakamitech.com.msusuariowebflux.domain.model.Rol;
import arakamitech.com.msusuariowebflux.domain.model.Usuario;
import arakamitech.com.msusuariowebflux.domain.port.out.RolRepositoryPort;
import arakamitech.com.msusuariowebflux.domain.port.out.UsuarioRepositoryPort;
import arakamitech.com.msusuariowebflux.shared.exception.DomainError;
import arakamitech.com.msusuariowebflux.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindAllTables {

    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final RolRepositoryPort rolRepositoryPort;

    public Mono<AllTables> findAllTables() {

    	Mono<List<Usuario>> usuariosMono = usuarioRepositoryPort.findAll()
    		    .doOnSubscribe(s -> log.info("Consultando usuarios"))
    		    .doOnNext(u -> log.info("USUARIOS REAL: {}", u))
    		    .onErrorMap(e -> {
    		        log.error("Error usuarios", e);
    		        return new DomainException(DomainError.ERROR_CONSULTANDO_USUARIOS);
    		    });

    		Mono<List<Rol>> rolesMono = rolRepositoryPort.findAll()
    		    .doOnSubscribe(s -> log.info("Consultando roles"))
    		    .doOnNext(r -> log.info("ROLES REAL: {}", r))
    		    .onErrorMap(e -> {
    		        log.error("Error roles", e);
    		        return new DomainException(DomainError.ERROR_CONSULTANDO_ROLES);
    		    });
    		return Mono.zip(rolesMono, usuariosMono)
    			    .doOnNext(tuple -> {
    			        System.out.println("ROLES FINAL: " + tuple.getT1());
    			        System.out.println("USUARIOS FINAL: " + tuple.getT2());
    			    })
    			    .map(tuple -> {
    			        log.info("Consultas completadas");
    			        return new AllTables(tuple.getT1(), tuple.getT2());
    			    });
    }

}

package arakamitech.com.msusuario.domain.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.stereotype.Service;

import arakamitech.com.msusuario.domain.model.AllTables;
import arakamitech.com.msusuario.domain.model.Rol;
import arakamitech.com.msusuario.domain.model.Usuario;
import arakamitech.com.msusuario.domain.port.out.RolRepositoryPort;
import arakamitech.com.msusuario.domain.port.out.UsuarioRepositoryPort;
import arakamitech.com.msusuario.shared.exception.DomainError;
import arakamitech.com.msusuario.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindAllTables {

	private final UsuarioRepositoryPort usuarioRepositoryPort;
	private final RolRepositoryPort rolRepositoryPort;
	private final Executor asyncExecutor;

	public AllTables findAllTables() {
		CompletableFuture<List<Usuario>> usersFuture = CompletableFuture.supplyAsync(() -> {
			log.info("Iniciando consulta de usuarios");
			return usuarioRepositoryPort.findAll();
		}, asyncExecutor).exceptionally(ex -> {
			log.error("Error consultando usuarios", ex);
			throw new DomainException(DomainError.ERROR_CONSULTANDO_USUARIOS);
		});

		CompletableFuture<List<Rol>> rolesFuture = CompletableFuture.supplyAsync(() -> {
			log.info("Iniciando consulta de roles");
			return rolRepositoryPort.findAll();
		}, asyncExecutor).exceptionally(ex -> {
			log.error("Error consultando roles", ex);
			throw new DomainException(DomainError.ERROR_CONSULTANDO_ROLES);
		});

		try {
			CompletableFuture.allOf(usersFuture, rolesFuture).join();

			List<Usuario> usuarios = usersFuture.join();
			List<Rol> roles = rolesFuture.join();

			log.info("Consultas completadas correctamente");

			return new AllTables(roles, usuarios);

		} catch (Exception ex) {
			log.error("Error consolidando información de tablas", ex);
			throw new DomainException(DomainError.ERROR_GENERAL);
		}
	}

}

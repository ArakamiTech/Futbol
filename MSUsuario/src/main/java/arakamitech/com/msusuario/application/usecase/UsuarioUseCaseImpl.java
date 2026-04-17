package arakamitech.com.msusuario.application.usecase;

import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import arakamitech.com.msusuario.domain.model.AllTables;
import arakamitech.com.msusuario.domain.model.Usuario;
import arakamitech.com.msusuario.domain.port.in.UsuarioUseCase;
import arakamitech.com.msusuario.domain.port.out.NotificacionProducerPort;
import arakamitech.com.msusuario.domain.port.out.UsuarioRepositoryPort;
import arakamitech.com.msusuario.domain.service.FindAllTables;
import arakamitech.com.msusuario.infrastructure.adapters.out.kafka.event.NotificacionEvent;
import arakamitech.com.msusuario.infrastructure.config.NotificacionProperties;
import arakamitech.com.msusuario.shared.exception.DomainError;
import arakamitech.com.msusuario.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

	private final UsuarioRepositoryPort usuarioRepositoryPort;
	private final NotificacionProducerPort notificacionProducerPort;
	private final FindAllTables finAdllTables;
	private final NotificacionProperties properties;

	@Override
	@Cacheable(value = "usuarios")
	public List<Usuario> findAll() {
		return usuarioRepositoryPort.findAll();
	}

	@Override
	@Cacheable(value = "usuario", key = "#id")
	public Usuario findById(Long id) {
		return usuarioRepositoryPort.findById(id).orElseThrow(() -> new DomainException(DomainError.USUARIO_NO_ENCONTRADO));
	}

	@Override
	@CachePut(value = "usuario", key = "#result.id")
	@CacheEvict(value = "usuarios", allEntries = true)
	public Usuario create(Usuario usuarioModel) {

		if (usuarioRepositoryPort.existsByNumeroIdentificacion(usuarioModel.getNumeroIdentificacion())) {
			throw new DomainException(DomainError.USUARIO_DUPLICADO);
		}

		Usuario usuario = new Usuario(usuarioModel.getNumeroIdentificacion(), usuarioModel.getNombre(),
				usuarioModel.getFechaNacimiento(), usuarioModel.getTipoIdentificacionId(), usuarioModel.getPaisId());

		Usuario usuarioGuardado = usuarioRepositoryPort.save(usuario);
		
		notificacionProducerPort.enviar(
		        new NotificacionEvent(
		            properties.getEmail(),
		            "Se ha creado el Usuario: " + usuarioGuardado.getNombre() + " a las " + new Date()
		        )
		    );
		
		return usuarioGuardado;
	}

	@Override
	@CachePut(value = "usuario", key = "#result.id")
	@CacheEvict(value = "usuarios", allEntries = true)
	public Usuario update(Long id, Usuario usuarioModel) {

		Usuario usuario = usuarioRepositoryPort.findById(id)
				.orElseThrow(() -> new DomainException(DomainError.USUARIO_NO_ENCONTRADO));

		usuario.actualizar(usuarioModel.getNombre(), usuarioModel.getFechaNacimiento(),
				usuarioModel.getTipoIdentificacionId(), usuarioModel.getPaisId());

		Usuario usuarioActualizado = usuarioRepositoryPort.save(usuario);
		
		notificacionProducerPort.enviar(
		        new NotificacionEvent(
		        		properties.getEmail(),
		            "Se ha actualizado el Usuario: " + usuarioActualizado.getNombre() + " a las " + new Date()
		        )
		    );
		
		return usuarioActualizado;
	}

	@Override
	@Caching(evict = { 
			@CacheEvict(value = "usuario", key = "#id"), 
			@CacheEvict(value = "usuarios", allEntries = true) })
	public void delete(Long id) {
		usuarioRepositoryPort.deleteById(id);
	}

	@Override
	@Cacheable(value = "alltables")
	public AllTables findAllTables() {
		return finAdllTables.findAllTables();
	}

}

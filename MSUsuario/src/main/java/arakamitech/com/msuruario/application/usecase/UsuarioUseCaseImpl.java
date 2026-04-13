package arakamitech.com.msuruario.application.usecase;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import arakamitech.com.msuruario.domain.model.Usuario;
import arakamitech.com.msuruario.domain.port.in.UsuarioUseCase;
import arakamitech.com.msuruario.domain.port.out.UsuarioRepositoryPort;
import arakamitech.com.msuruario.infrastructure.adapters.out.kafka.NotificacionProducer;
import arakamitech.com.msuruario.infrastructure.adapters.out.kafka.event.NotificacionEvent;
import arakamitech.com.msuruario.infrastructure.config.NotificacionProperties;
import arakamitech.com.msuruario.shared.exception.DomainError;
import arakamitech.com.msuruario.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

	private final UsuarioRepositoryPort usuarioRepositoryPort;
	private final NotificacionProducer notificacionProducer;
	private final NotificacionProperties properties;

	@Value("${app.notificaciones.email}")
	private String emailNotificacion;

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
		
		notificacionProducer.enviar(
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
		
		notificacionProducer.enviar(
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

}

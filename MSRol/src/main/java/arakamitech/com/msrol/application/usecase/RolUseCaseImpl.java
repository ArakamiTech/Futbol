package arakamitech.com.msrol.application.usecase;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import arakamitech.com.msrol.domain.model.Rol;
import arakamitech.com.msrol.domain.port.in.RolUseCase;
import arakamitech.com.msrol.domain.port.out.RolRepositoryPort;
import arakamitech.com.msrol.shared.exception.DomainError;
import arakamitech.com.msrol.shared.exception.DomainException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RolUseCaseImpl implements RolUseCase {

	private final RolRepositoryPort rolRepositoryPort;

	@Override
	@Cacheable(value = "roles")
	public List<Rol> findAll() {
		return rolRepositoryPort.findAll();
	}

	@Override
	@Cacheable(value = "rol", key = "#id")
	public Rol findById(Long id) {
		return rolRepositoryPort.findById(id).orElseThrow(() -> new DomainException(DomainError.ROL_NO_ENCONTRADO));
	}

	@Override
	@CachePut(value = "rol", key = "#nombre")
	@CacheEvict(value = "roles", allEntries = true)
	public Rol create(String nombre) {

		if (rolRepositoryPort.existsByNombre(nombre)) {
			throw new DomainException(DomainError.ROL_DUPLICADO);
		}

		return rolRepositoryPort.save(new Rol(nombre));
	}

	@Override
	@CachePut(value = "rol", key = "#nombre")
	@CacheEvict(value = "roles", allEntries = true)
	public Rol update(Long id, String nombre) {

		Rol rol = rolRepositoryPort.findById(id).orElseThrow(() -> new DomainException(DomainError.ROL_NO_ENCONTRADO));

		rol.actualizarNombre(nombre);

		return rolRepositoryPort.save(rol);
	}

	@Override
	@Caching(evict = { 
			@CacheEvict(value = "rol", key = "#id"), 
			@CacheEvict(value = "roles", allEntries = true) })
	public void delete(Long id) {
		rolRepositoryPort.deleteById(id);
	}

}

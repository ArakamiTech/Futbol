package arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import arakamitech.com.msusuario.domain.model.Rol;
import arakamitech.com.msusuario.domain.port.out.RolRepositoryPort;
import arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.mapper.RolPersistenceMapper;
import arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.repository.RolRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RolRepositoryAdapter implements RolRepositoryPort {
	
	private final RolRepository rolRepository;
	private final RolPersistenceMapper rolPersistenceMapper;

	@Override
	public List<Rol> findAll() {
		return rolPersistenceMapper.toDomainList(rolRepository.findAll());
	}

}

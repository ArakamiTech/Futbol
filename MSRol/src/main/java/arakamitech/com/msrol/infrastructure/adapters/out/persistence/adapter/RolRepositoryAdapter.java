package arakamitech.com.msrol.infrastructure.adapters.out.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import arakamitech.com.msrol.domain.model.Rol;
import arakamitech.com.msrol.domain.port.out.RolRepositoryPort;
import arakamitech.com.msrol.infrastructure.adapters.out.persistence.entity.RolEntity;
import arakamitech.com.msrol.infrastructure.adapters.out.persistence.entity.repository.RolRepository;
import arakamitech.com.msrol.infrastructure.adapters.out.persistence.mapper.RolPersistenceMapper;
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
	
	@Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id)
                .map(rolPersistenceMapper::toDomain);
    }

    @Override
    public Rol save(Rol rol) {
        RolEntity entity = rolRepository.save(rolPersistenceMapper.toEntity(rol));
        return rolPersistenceMapper.toDomain(entity);
    }

    @Override
    public void deleteById(Long id) {
    	rolRepository.deleteById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return rolRepository.existsByNombre(nombre);
    }

}

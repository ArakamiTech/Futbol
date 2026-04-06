package arakamitech.com.msuruario.infrastructure.adapters.out.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import arakamitech.com.msuruario.domain.model.Usuario;
import arakamitech.com.msuruario.domain.port.out.UsuarioRepositoryPort;
import arakamitech.com.msuruario.infrastructure.adapters.out.persistence.entity.UsuarioEntity;
import arakamitech.com.msuruario.infrastructure.adapters.out.persistence.mapper.UsuarioPersistenceMapper;
import arakamitech.com.msuruario.infrastructure.adapters.out.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {
	
	private final UsuarioRepository usuarioRepository;
	private final UsuarioPersistenceMapper usuarioPersistenceMapper;

	@Override
	public List<Usuario> findAll() {
		return usuarioPersistenceMapper.toDomainList(usuarioRepository.findAll());
	}
	
	@Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioPersistenceMapper::toDomain);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = usuarioRepository.save(usuarioPersistenceMapper.toEntity(usuario));
        return usuarioPersistenceMapper.toDomain(entity);
    }

    @Override
    public void deleteById(Long id) {
    	usuarioRepository.deleteById(id);
    }

	@Override
	public boolean existsByNumeroIdentificacion(String numeroIdentificacion) {
		return usuarioRepository.existsByNumeroIdentificacion(numeroIdentificacion);
	}

}

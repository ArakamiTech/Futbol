package arakamitech.com.msuruario.domain.port.out;

import java.util.List;
import java.util.Optional;

import arakamitech.com.msuruario.domain.model.Usuario;

public interface UsuarioRepositoryPort {

	List<Usuario> findAll();
	Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
	boolean existsByNumeroIdentificacion(String numeroIdentificacion);

}

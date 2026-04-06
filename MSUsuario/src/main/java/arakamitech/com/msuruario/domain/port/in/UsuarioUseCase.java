package arakamitech.com.msuruario.domain.port.in;

import java.util.List;

import arakamitech.com.msuruario.domain.model.Usuario;

public interface UsuarioUseCase {

	List<Usuario> findAll();
	Usuario findById(Long id);
    Usuario create(Usuario request);
    Usuario update(Long id, Usuario usuario);
    void delete(Long id);

}

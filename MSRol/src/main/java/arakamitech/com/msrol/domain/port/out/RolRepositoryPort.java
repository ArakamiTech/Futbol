package arakamitech.com.msrol.domain.port.out;

import java.util.List;
import java.util.Optional;

import arakamitech.com.msrol.domain.model.Rol;

public interface RolRepositoryPort {

	List<Rol> findAll();
	Optional<Rol> findById(Long id);
    Rol save(Rol rol);
    void deleteById(Long id);
    boolean existsByNombre(String nombre);

}

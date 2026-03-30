package arakamitech.com.msrol.domain.port.in;

import java.util.List;

import arakamitech.com.msrol.domain.model.Rol;

public interface RolUseCase {

	List<Rol> findAll();
	Rol findById(Long id);
    Rol create(String nombre);
    Rol update(Long id, String nombre);
    void delete(Long id);

}

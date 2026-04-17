package arakamitech.com.msusuario.domain.port.out;

import java.util.List;

import arakamitech.com.msusuario.domain.model.Rol;

public interface RolRepositoryPort {

	List<Rol> findAll();

}

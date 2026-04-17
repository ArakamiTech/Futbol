package arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arakamitech.com.msusuario.infrastructure.adapters.out.rol.persistence.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

	boolean existsByNombre(String nombre);

}

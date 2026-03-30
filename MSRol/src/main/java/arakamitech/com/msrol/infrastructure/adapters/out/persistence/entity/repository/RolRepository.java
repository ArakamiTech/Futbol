package arakamitech.com.msrol.infrastructure.adapters.out.persistence.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arakamitech.com.msrol.infrastructure.adapters.out.persistence.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {

	boolean existsByNombre(String nombre);

}

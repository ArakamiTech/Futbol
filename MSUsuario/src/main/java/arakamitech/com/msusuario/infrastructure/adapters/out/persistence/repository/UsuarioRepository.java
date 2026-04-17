package arakamitech.com.msusuario.infrastructure.adapters.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arakamitech.com.msusuario.infrastructure.adapters.out.persistence.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	boolean existsByNumeroIdentificacion(String numeroIdentificacion);

}
